package ca.scooter.talkufy.utils

import android.Manifest
import android.animation.Animator
import android.app.Activity
import android.app.ActivityManager
import android.content.ContentValues
import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.*
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.ContactsContract
import android.provider.MediaStore
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.View
import android.view.ViewAnimationUtils
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.multidex.BuildConfig
import ca.scooter.talkufy.R
import ca.scooter.talkufy.models.Models
import ca.scooter.talkufy.utils.FileUtils.getFilePath
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern
import kotlin.math.hypot
import kotlin.math.log10
import kotlin.math.pow


object utils {


    object constants {

        const val FILE_TYPE_IMAGE = "image"
        const val FILE_TYPE_LOCATION = "location"
        const val FILE_TYPE_VIDEO = "video"
        const val KEY_IMG_PATH = "path"
        const val KEY_CAPTION = "caption"
        const val KEY_LOCAL_PATH = "local_path"

        const val KEY_TARGET_TYPE = "target_type"
        const val KEY_NAME_OR_NUMBER = "name_or_number"

        const val KEY_SELECTED = "selected"
        const val KEY_IS_GROUP = "isGroup"
        const val KEY_IS_CHANNEL = "isChannel"

        const val KEY_EXCLUDED_LIST = "excluded_list"

        const val KEY_IS_ON_ACCOUNT_CREATION = "on_acc_creation"
        const val KEY_IS_ONCE = "is_once"

        const val KEY_IS_FOR_SELECTION = "for_selection"


        const val KEY_MSG_MODEL = "msg_model"

        const val KEY_LATITUDE = "lat"
        const val KEY_LONGITUDE = "lng"
        const val KEY_ADDRESS = "address"

        const val KEY_NAME = "name"

        const val IS_FOR_SINGLE_FILE = "isSingleFile"
        const val URI_AUTHORITY = "com.mvc.imagepicker.provider"

        const val KEY_FILE_TYPE = "type"
        const val debugUserID = ""
        const val KEY_UNREAD = "unread"

        const val REGEX_PATTERN_PHONE = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}\$"


        const val PHONE_STATE_INCOMING_CALL = "incoming_call"
        const val PHONE_STATE_ONGOING_CALL = "ongoing_call"
        const val PHONE_STATE_IDLE = "phone_idle"

        const val CALL_STATUS_CALLING = "Calling"
        const val CALL_STATUS_REJECTED = "Rejected"
        const val CALL_STATUS_ANSWERED = "Answered"
        const val CALL_STATUS_RINGING = "Ringing"
        const val CALL_STATUS_BUSY = "Busy"
        const val CALL_STATUS_ANOTHER_CALL = "Another_Call"
        const val CALL_STATUS_CALL_ENDED = "Call_Ended"
        const val CALL_STATUS_CALL_JOINED = "Joined"


        const val APP_SHORT_LINK = "https://goo.gl/TzQgdm"
        const val APP_LINK = "https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
        const val SHARING_TEXT = "Download Talkufy - A completely free & realtime call ,chat, etc app, for me I use it to connect to my family"

    }

    fun isGroupID(id:String):Boolean = id.startsWith("GRP") && id.replace("GRP","")
        .matches(Regex("\\d+"))


    fun isChannelID(id:String):Boolean = id.startsWith("CHN") && id.replace("CHN","")
        .matches(Regex("\\d+"))


    fun toast(context: Context?, message: CharSequence) =
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    fun longToast(context: Context?, message: CharSequence) =
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()


    fun getFormattedTenDigitNumber(number:String ) : String {
        var out = Pattern.compile("[^0-9]").matcher(number).replaceAll("")

        if(out.length>10){
            out = number.substring(number.length - 10)
        }

        return out
    }


    fun printIntentKeyValues(intent:Intent){
        intent.extras?.keySet()?.forEach {
            Log.d("Intent values ", " passed value -> $it = ${intent.extras?.get(it)}")
        }
    }


    fun getContactList(context: Context?) : MutableList<Models.Contact>{

        val numberList:MutableList<Models.Contact> = mutableListOf()
        val cursor = context!!.contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null , null, null , null)

        while(cursor!!.moveToNext()){

            var name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            var number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

            var pic = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI))

            number = getFormattedTenDigitNumber(number)

            if(pic == null)
                pic = ""

            if(name == null)
                name = ""



            var isDuplicate = false
            for(item in numberList){
                if(item.number == number ) {
                    isDuplicate = true
                    break

                }

            }

            if(FirebaseUtils.isLoggedIn()){
                isDuplicate = FirebaseAuth.getInstance().currentUser!!.phoneNumber == number
            }

            if(!isDuplicate && !numberList.any { it.number == number })
                numberList.add(Models.Contact(name, number , pic))


        }

        cursor.close()
        return numberList

    }



    fun hasContactPermission(context: Context) = (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED)

    fun hasCallPermission(context: Context) = (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)

    fun hasStoragePermission(context: Context) = (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            && (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)

    fun getLocalTime(timeInMillis: Long): String{

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())

        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(calendar.time).uppercase(Locale.getDefault()).replace(".","")
    }

    fun getLocalDate(timeInMillis: Long): String{

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val sdf = SimpleDateFormat("MMM dd")

        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(calendar.time)
    }

    fun getLocalDateWithYear(timeInMillis: Long): String{

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val sdf = SimpleDateFormat("MMM dd yyyy")

        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(calendar.time)
    }


    fun getHeaderFormattedDate(timeInMillis: Long): String{
        return when{
            DateFormatter.isToday(Date(timeInMillis)) -> "Today"
            DateFormatter.isYesterday(Date(timeInMillis)) -> "Yesterday"
            DateFormatter.isCurrentYear(
                Date(
                    timeInMillis
                )
            ) -> getLocalDate(timeInMillis)
            else -> getLocalDateWithYear(timeInMillis)

        }
    }

    fun getUtcTimeFromMillis(timeInMillis:Long) : String{

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val sdf = SimpleDateFormat("hh:mm a")

        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(calendar.time)
    }


    fun getByteArrayFromBitmap(bitmap: Bitmap) : ByteArray {
        val bout = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG,100, bout)
        return bout.toByteArray()
    }

    fun getBitmapFromByteArray(byteArray: ByteArray) : Bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)


    fun setEnterRevealEffect(activity:Activity, view:View): Animator? {


        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            view.visibility = View.VISIBLE
            return null
        }


        // get the center for the clipping circle
        val cx = (view.left )
        val cy = (view.top + view.bottom)

        // get the final radius for the clipping circle
        val dx = cx.coerceAtLeast(view.width - cx).toDouble()
        val dy = cy.coerceAtLeast(view.height - cy).toDouble()
        val finalRadius =  hypot(x = dx, y = dy).toFloat()

        val animator =
            ViewAnimationUtils.createCircularReveal(view, cx, cy, 0f, finalRadius)
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 300

        animator.addListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
                activity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            }

            override fun onAnimationStart(animation: Animator?) {
                view.visibility = View.VISIBLE
                activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            }

        })
        animator.start()


        return animator

    }


    fun setExitRevealEffect(view:View): Animator? {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            view.visibility = View.GONE
            return null
        }

        val cx = ( view.right + view.left)
        val cy = (view.top + view.bottom)

        // get the final radius for the clipping circle
        val dx = cx.coerceAtLeast(view.width + cx)
        val dy = cy.coerceAtLeast(view.height + cy)
        val finalRadius = hypot(dx.toDouble(), dy.toDouble()).toFloat()

        val animator =
            ViewAnimationUtils.createCircularReveal(view, cx, cy, finalRadius, 0f)
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 400

        animator.addListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.visibility = View.GONE
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })

        animator.start()


        return animator


    }


    fun saveBitmapToSent(context: Context?, bitmap: Bitmap, messageIdForName:String):String{

        val file =
            getSentBitmapFile(context, messageIdForName)

        try {

            val fout = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout)
            Log.d("utils", "saveBitmap: file saved to ${file.path}")

        }
        catch (e:Exception){
            Log.d("utils", "saveBitmap: File not found")
        }

        return file.path
    }


    fun getProfilePicPath(context: Context):String = Environment.getExternalStorageDirectory().toString()+"/"+ context.getString(R.string.app_name) +"" +
            "/ProfilePics/"

    fun saveBitmapToProfileFolder(context: Context?, bitmap: Bitmap, messageIdForName:String):String{

        val fileName = "$messageIdForName.jpg"

        val path = Environment.getExternalStorageDirectory().toString()+"/"+ context!!.getString(R.string.app_name) +"" +
                "/ProfilePics/"

        if(!File(path).exists())
            File(path).mkdirs()

        val file = File(path, fileName)

        try {

            if(file.exists()){
                file.delete()
                Log.d("utils", "saveBitmapToProfileFolder: old file deleted")
            }

            val fout = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout)
            Log.d("utils", "saveBitmap: file saved to ${file.path}")


//            val values = ContentValues(3)
//            values.put(MediaStore.Video.Media.TITLE, messageIdForName)
//            values.put(MediaStore.Video.Media.MIME_TYPE, "image/*")
//            values.put(MediaStore.Video.Media.DATA, file.absolutePath)
//            context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)


        }
        catch (e:Exception){
            Log.d("utils", "saveBitmap: File not found")
        }

        return file.path
    }

    private fun getSentBitmapFile(context: Context?, messageIdForName:String):File{
        val fileName = "$messageIdForName.jpg"

        val path = Environment.getExternalStorageDirectory().toString()+"/"+ context!!.getString(R.string.app_name) +"" +
                "/Images/Sent/"

        if(!File(path).exists())
            File(path).mkdirs()

        return File(path, fileName)
    }


    private fun getReceivedBitmapFile(context: Context?, messageIdForName:String):File{
        val fileName = "$messageIdForName.jpg"

        val path = Environment.getExternalStorageDirectory().toString()+"/"+ context!!.getString(R.string.app_name) +"" +
                "/Images/Received/"

        if(!File(path).exists())
            File(path).mkdirs()

        return File(path, fileName)
    }

    fun saveBitmapToReceived(context: Context?, bitmap: Bitmap, messageIdForName:String):String{


        val file = getReceivedBitmapFile(
            context,
            messageIdForName
        )

        try {

            val fout = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout)
            Log.d("utils", "saveBitmap: file saved to ${file.path}")

            if(!Pref.isMediaVisible(context!!))
                return file.path

            val values = ContentValues(3)
            values.put(MediaStore.Video.Media.TITLE, messageIdForName)
            values.put(MediaStore.Video.Media.MIME_TYPE, "image/*")
            values.put(MediaStore.Video.Media.DATA, file.absolutePath)
            context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        }
        catch (e:Exception){
            Log.d("utils", "saveBitmap: File not found")
        }

        return file.path
    }

    fun getVideoLength(context: Context?, videoFilePath:String): String? {
        try {

            val retriever = MediaMetadataRetriever()
            retriever.setDataSource(context,
                getUriFromFile(
                    context,
                    File(videoFilePath)
                )
            )
            val time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            val timeInMillisec = time?.toLong()

            retriever.release()

            return timeInMillisec?.let { getDurationString(it) }
        }
        catch (e:Exception){return ""}

    }


    fun startVideoIntent(context: Context, videoPath: String){
        try{
            val videoIntent = Intent(Intent.ACTION_VIEW)
            val uri =
                getUriFromFile(context, File(videoPath))
            videoIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            videoIntent.setDataAndType(uri, "video/*")
            context.startActivity(videoIntent)
        }
        catch (e:Exception){
            toast(context, e.message.toString())
        }
    }


    private fun getDurationString(duration: Long): String {

        val hours = duration % (1000 * 60 * 60 * 24) / (1000 * 60 * 60)
        val minutes = duration % (1000 * 60 * 60) / (1000 * 60)
        val seconds = duration % (1000 * 60) / 1000

        val hourStr = if (hours < 10) "0$hours" else hours.toString() + ""
        val minuteStr = if (minutes < 10) "0$minutes" else minutes.toString() + ""
        val secondStr = if (seconds < 10) "0$seconds" else seconds.toString() + ""

        return if (hours != 0L) {
            "$hourStr:$minuteStr:$secondStr"
        } else {
            "$minuteStr:$secondStr"
        }
    }

    fun getFileSize(sizeInBytes:Long):String{

        if (sizeInBytes <= 0)
            return "0"

        val units = arrayOf( "B", "KB", "MB", "GB", "TB" )
        val digitGroups = (log10(sizeInBytes.toDouble()) / log10(1024.0)).toInt()

        return  DecimalFormat("#,##0.#").format(sizeInBytes / 1024.0.pow(digitGroups.toDouble())) + " " + units[digitGroups]

    }


    fun setVideoThumbnailFromWebAsync(context: Context, videoPath: String, imageView: ImageView){

        Glide.with(context)
            .load(videoPath)
            .thumbnail(0.1f)
            .into(imageView)

    }


    fun loadVideoThumbnailFromLocalAsync(context: Context, imageView: ImageView, path:String){

        Glide.with(context)
            .load(path)
            .thumbnail(0.1f)
            .into(imageView)

    }


    fun getVideoFile(context: Context?, messageIdForName: String):File {

        val fileName = "$messageIdForName.mp4"

        val path =
            Environment.getExternalStorageDirectory().toString() + "/" + context!!.getString(R.string.app_name) + "" +
                    "/Video/Received/"

        if (!File(path).exists())
            File(path).mkdirs()

        val file = File(path, fileName)
        return file
    }

    fun saveVideo(context: Context?, fileBytes: ByteArray, messageIdForName:String):String{

        val fileName = "$messageIdForName.mp4"

        val path = Environment.getExternalStorageDirectory().toString()+"/"+ context!!.getString(R.string.app_name) +"" +
                "/Video/Received/"

        if(!File(path).exists())
            File(path).mkdirs()

        val file = File(path, fileName)

        try {

            val fout = FileOutputStream(file)
            fout.write(fileBytes)
            //  bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout)
            Log.d("utils", "saveVideo: file saved to ${file.path}")

            addVideoToMediaStore(
                context,
                messageIdForName,
                file
            )
        }
        catch (e:Exception){
            Log.d("utils", "saveVideo: File not found")
        }

        return file.path
    }


    fun addVideoToMediaStore(context:Context, messageIdForName: String, file: File){

        if(!Pref.isMediaVisible(context))
            return

        val values = ContentValues(3)
        values.put(MediaStore.Video.Media.TITLE, messageIdForName)
        values.put(MediaStore.Video.Media.MIME_TYPE, "video/mp4")
        values.put(MediaStore.Video.Media.DATA, file.absolutePath)

        //getting video length
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(context,
            getUriFromFile(context, file)
        )
        val time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
        val timeInMillisec = time?.toLong()

        retriever.release()

        values.put(MediaStore.Video.Media.DURATION, timeInMillisec )
        context.contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values)

    }


    fun highlightTextView(textView: TextView, highlightedText:String, color:Int) {

        try {
            val text = textView.text.toString().lowercase(Locale.getDefault())

            val startIndex = text.indexOf(highlightedText.lowercase(Locale.getDefault()))
            val endIndex = startIndex + highlightedText.length

            val spannableString = SpannableString(text)
            spannableString.setSpan(
                BackgroundColorSpan(color), startIndex,
                endIndex, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            )


            textView.text = spannableString
        }
        catch (_:Exception){}
    }


    fun hideSoftKeyboard(activity: Activity) {
        try {
            val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }



    fun getUriFromFile(context: Context?, file:File) : Uri {

        var uri = Uri.fromFile(file)
        return try {

            if (Build.VERSION.SDK_INT >= 24)
                uri = FileProvider.getUriForFile(context!!,
                    constants.URI_AUTHORITY, file)

            uri
        } catch (e:Exception){
            Log.e("utils", "utils: getUriFromFile = ${e.message}")
            uri
        }
    }

    fun isAppIsInBackground(context: Context):Boolean {
        var isInBackground = true
        val am =  context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            val runningProcesses = am.runningAppProcesses
            for (processInfo in runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for ( activeProcess in  processInfo.pkgList) {
                        if (activeProcess == context.packageName) {
                            isInBackground = false
                        }
                    }
                }
            }
        } else {
            val taskInfo = am.getRunningTasks(1)
            val componentInfo = taskInfo[0].topActivity
            if (componentInfo != null) {
                if (componentInfo.packageName == context.packageName) {
                    isInBackground = false
                }
            }
        }

        return isInBackground
    }

    //provide unformatted number
    fun getNameFromNumber(context: Context, number: String):String{


        try {


            if(number == getFormattedTenDigitNumber(FirebaseUtils.getPhoneNumber())
                || number.contains(
                    getFormattedTenDigitNumber(
                        FirebaseUtils.getPhoneNumber()
                    )
                )) {
                return "You"
            }

            val list = getContactList(context)

            for (item in list) {
                val formattedNumber =
                    getFormattedTenDigitNumber(item.number)
                if (getFormattedTenDigitNumber(number) == formattedNumber) {
                    return item.name
                }
            }
        }
        catch (e:Exception){
            return number
        }
        return number
    }


    fun vibrate(context: Context) {
        if (Build.VERSION.SDK_INT >= 26) {
            (context.getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            ( context.getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(200)
        }
    }


    fun hideFabs(vararg fabs: FloatingActionButton){
        fabs.forEach {
            it.hide()
        }
    }

    fun showFabs(vararg fabs: FloatingActionButton){
        fabs.forEach {
            it.show()
        }
    }


    fun shareInviteText(context: Context){
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT,
                constants.SHARING_TEXT
            )
            putExtra(Intent.EXTRA_SUBJECT, "SS Talk")
        }

        context.startActivity(Intent.createChooser(intent, "Share via"))
    }

    fun getRealPathFromURI(context: Context, contentUri: Uri): String {
        var cursor: Cursor? = null
        return try {
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            cursor = context.contentResolver.query(contentUri, proj, null, null, null)
            val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            cursor.getString(column_index)
        } catch (e:Exception){
            Log.e("utils", "getRealPathFromURI: error = ${e.message}")
            getFilePath(context, contentUri)
        } finally {
            cursor?.close()
        }

    }




    fun Context.toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun Context.longToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }


    fun getCircleBitmap( bitmap:Bitmap):Bitmap {
        val output: Bitmap?
        val srcRect: Rect?
        val dstRect: Rect?
        val r: Float
        val width = bitmap.width
        val height = bitmap.height

        if (width > height){
            output = Bitmap.createBitmap(height, height, Bitmap.Config.ARGB_8888)
            val left = (width - height) / 2
            val right = left + height
            srcRect =  Rect(left, 0, right, height)
            dstRect =  Rect(0, 0, height, height)
            r = (height / 2).toFloat()
        }else{
            output = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888)
            val top = (height - width)/2
            val bottom = top + width
            srcRect =  Rect(0, top, width, bottom)
            dstRect =  Rect(0, 0, width, width)
            r = (width / 2).toFloat()
        }

        val canvas =  Canvas(output!!)

        val color = 0xff424242
        val paint =  Paint()

        paint.isAntiAlias = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = color.toInt()
        canvas.drawCircle(r, r, r, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, srcRect, dstRect, paint)

        bitmap.recycle()

        return output

    }

    fun getFileExtension(file:File):String {
        return try {
            val path = file.path
            path.substring(path.lastIndexOf("."))
        } catch (e:Exception){
            ""
        }
    }


    // slide the view from below itself to the current position
    fun slideUp(view:View){
        view.visibility = View.VISIBLE
        val animate = TranslateAnimation(
            0f,                 // fromXDelta
            0f,                 // toXDelta
            view.height.toFloat(),  // fromYDelta
            0f)                // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    // slide the view from its current position to below itself
    fun slideDown(view:View){
        val animate =  TranslateAnimation(
            0f,                 // fromXDelta
            0f,                 // toXDelta
            0f,                 // fromYDelta
            view.height.toFloat()
        ) // toYDelta
        animate.duration = 500
        animate.fillAfter = false
        view.startAnimation(animate)
    }
}