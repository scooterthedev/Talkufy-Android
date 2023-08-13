package ca.scooter.talkufy.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import ca.scooter.talkufy.R;
import ca.scooter.talkufy.jitsi_sdk.JitsiMeetConferenceOptions;
import ca.scooter.talkufy.models.Models;
import ca.scooter.talkufy.utils.FirebaseUtils;
import ca.scooter.talkufy.utils.utils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import de.hdodenhof.circleimageview.CircleImageView;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import timber.log.Timber;
import www.sanju.motiontoast.MotionToast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class OutgoingCallActivity extends AppCompatActivity {

    private static final String TAG = "OutgoingCallActivity";
    private AnimationDrawable animationDrawable;

    private final String myUid = FirebaseUtils.INSTANCE.getUid();
    private boolean audioOnly;
    private String call_id;
    private String TARGET_TYPE = "single";
    private String TARGET_UID;
    private String calltype = "single";

    private CountDownTimer callingCountdown;

    private ImageView buttonReject;
    private TextView call_state_info;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_outgoing_call);

        if (getIntent() == null)
            finish();

        Objects.requireNonNull(getSupportActionBar()).hide();
        // init constraintLayout
        LinearLayout layout = findViewById(R.id.linearLayout);
        // initializing animation drawable by getting background from constraint layout
        animationDrawable = (AnimationDrawable) layout.getBackground();
        // setting enter fade animation duration to 5 seconds
        animationDrawable.setEnterFadeDuration(5000);
        // setting exit fade animation duration to 2 seconds
        animationDrawable.setExitFadeDuration(2000);


        call_id = getIntent().getStringExtra("call_id");
        String target_name = getIntent().getStringExtra("target_name");
        String target_phone = getIntent().getStringExtra("target_phone");
        String target_uid = getIntent().getStringExtra("target_uid");
        String target_type = getIntent().getStringExtra("target_type");
        audioOnly = getIntent().getBooleanExtra("audioOnly", true);

        TARGET_TYPE = target_type;
        TARGET_UID = target_uid;

        buttonReject = findViewById(R.id.buttonReject);
        ImageView call_type_image = findViewById(R.id.call_type_image);
        TextView call_type_text = findViewById(R.id.call_type_text);
        call_state_info = findViewById(R.id.call_state_info);

        CircleImageView caller_imageview = findViewById(R.id.caller_imageview);

        assert target_uid != null;
        FirebaseUtils.INSTANCE.loadProfilePic(this, target_uid, caller_imageview);
        TextView callerName = findViewById(R.id.callername);
        TextView callerNumber = findViewById(R.id.callernumber);
        callerName.setText(target_name);
        callerNumber.setText(target_phone);


        if (!audioOnly) {
            call_type_text.setText("Video Call");
            call_type_image.setImageResource(R.drawable.vw_ic_video_camera);
        }

        call_state_info.setOnClickListener(v -> finish());

        buttonReject.setOnClickListener(v -> {
            callingCountdown.cancel();

            @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
            String format = simpleDateFormat.format(new Date());

            FirebaseUtils.ref.INSTANCE.callRef(TARGET_UID).child("call_status")
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                if (Objects.requireNonNull(dataSnapshot.getValue()).toString().equals(utils.constants.CALL_STATUS_RINGING)){
                                    createCallLog(" canceled a call at "+format,1);
                                }else {
                                    createCallLog(" canceled a call at "+format,2);
                                }
                            }else{
                                createCallLog(" canceled a call at "+format,1);
                            }
                            finish();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            MotionToast.Companion.darkColorToast(
                                    OutgoingCallActivity.this, "Error!",
                                    MotionToast.Companion.getTOAST_ERROR(),
                                    MotionToast.Companion.getGRAVITY_BOTTOM(),
                                    MotionToast.Companion.getLONG_DURATION(),
                                    ResourcesCompat.getFont(OutgoingCallActivity.this, R.font.helvetica_regular));
                        }
                    });
        });

        assert target_type != null;
        if (target_type.equals("single")) {
            initiateCallNow(call_id, audioOnly);
        } else {
            initiateGroupConference(target_uid, audioOnly);
        }


    }


    private void initiateGroupConference(String targetUid, Boolean audioOnly) {
        FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid()).setValue(
                new Models.callModel(targetUid, FirebaseUtils.INSTANCE.getUid(), targetUid,
                        String.valueOf(System.currentTimeMillis()),
                        utils.constants.CALL_STATUS_CALL_JOINED,
                        "conference", "group", audioOnly))
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        //Join user to meeting no
                        joinMeToCallNow();
                    } else {
                        Toast.makeText(OutgoingCallActivity.this,
                                "Couldn't Join Meeting, please try again", Toast.LENGTH_LONG).show();
                    }
                });


    }


    private void initiateCallNow(String callId, Boolean audioOnly) {

        if (!TARGET_TYPE.equals("single")) calltype = "Conference";
        String startTimeMills = String.valueOf(System.currentTimeMillis());

        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        String format = simpleDateFormat.format(new Date());

        FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid()).setValue(
                new Models.callModel(callId, FirebaseUtils.INSTANCE.getUid(), TARGET_UID,
                        startTimeMills, utils.constants.CALL_STATUS_CALLING, calltype,
                        TARGET_TYPE, audioOnly))
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        FirebaseUtils.ref.INSTANCE.callRef(TARGET_UID).setValue(
                                new Models.callModel(callId, FirebaseUtils.INSTANCE.getUid(), TARGET_UID,
                                        startTimeMills, utils.constants.CALL_STATUS_CALLING,
                                        calltype, TARGET_TYPE, audioOnly))
                                .addOnCompleteListener(task1 -> {
                                    if (task.isSuccessful()) {

                                        final ProgressDialog progressDialog = new ProgressDialog(this);
                                        progressDialog.setTitle("Connecting you to your call");
                                        progressDialog.setMessage("");

                                        eyeCallStatus(progressDialog, format, startTimeMills);

                                        callingCountdown = new CountDownTimer(45000, 1000) {
                                            public void onTick(long millisUntilFinished) {
                                                progressDialog.setMessage("Remaining Time " + millisUntilFinished / 1000);

                                            }

                                            @Override
                                            public void onFinish() {
                                                createCallLog(" couldn't establish call at " + format,1);
                                                progressDialog.setMessage("Call could not Established...");
                                            }

                                        }.start();
                                        progressDialog.show();
                                    } else {
                                        abort();
                                        createCallLog(" couldn't establish call at " + format,1);
                                        Toast.makeText(this, "Sorry Couldn't initiate call...", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } else {
                        createCallLog(" couldn't establish call at " + format,1);
                        Toast.makeText(this, "Sorry Couldn't initiate call...", Toast.LENGTH_SHORT).show();
                    }
                });


    }

    private void eyeCallStatus(ProgressDialog progressDialog,
                               String startTime, String startTimeMills) {
        //Check if target's phone is
        //1. Receiving an incoming call from telephoneManager(Busy)
        //2. On an in ongoing call with telephoneManager(on another call)
        //3. Ringing for our call(Call Ringing)
        //4. Rejecting our call(Call Rejected)
        //5. Answered to our call(Answered)

        FirebaseUtils.ref.INSTANCE.callRef(TARGET_UID)
                .addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists() && dataSnapshot.hasChild("call_status")) {
                            String call_status = Objects.requireNonNull(dataSnapshot.child("call_status").getValue()).toString();
                            long duration = 0;

                            switch (call_status) {
                                case utils.constants.CALL_STATUS_RINGING:
                                    callingCountdown.cancel();
                                    progressDialog.setMessage("Ringing...");

                                    callingCountdown = new CountDownTimer(45000, 1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {

                                        }

                                        @Override
                                        public void onFinish() {
                                            progressDialog.hide();
                                            createCallLog("  missed a Meeting at " + startTime,2);
                                            buttonReject.setVisibility(View.GONE);
                                            call_state_info.setText("No Answer");
                                        }
                                    }.start();
                                    break;
                                case utils.constants.CALL_STATUS_ANSWERED:
                                    callingCountdown.cancel();
                                    progressDialog.hide();
                                    ////Check duration
                                    duration = System.currentTimeMillis();
                                    //Join user to meeting no
                                    joinMeToCallNow();

                                    break;
                                case utils.constants.CALL_STATUS_REJECTED:
                                    callingCountdown.cancel();
                                    progressDialog.setMessage("Rejected");
                                    createCallLog(" rejected a Meeting at " + startTime,2);

                                    buttonReject.setVisibility(View.GONE);
                                    call_state_info.setText("Meeting Rejected");
                                    break;
                                case utils.constants.CALL_STATUS_BUSY:
                                    progressDialog.setMessage("Busy");
                                    callingCountdown.cancel();
                                    createCallLog("'s phone was busy at " + startTime,2);

                                    buttonReject.setVisibility(View.GONE);
                                    call_state_info.setText("User Busy");
                                    break;
                                case utils.constants.CALL_STATUS_ANOTHER_CALL:
                                    callingCountdown.cancel();
                                    progressDialog.setMessage("Rejected");
                                    createCallLog(" was another an a call at " + startTime,2);

                                    buttonReject.setVisibility(View.GONE);
                                    call_state_info.setText("User On Call");
                                    break;
                                case utils.constants.CALL_STATUS_CALL_ENDED:
                                    progressDialog.setMessage("Meeting Ended...");
                                    createCallLog(" was called at " + startTime + ", Duration " +
                                            getDurationBreakdown(duration - Long.parseLong(startTimeMills)),2);

                                    buttonReject.setVisibility(View.GONE);
                                    call_state_info.setText("Meeting Ended");
                                    break;
                            }
                        } else {
                            abort();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }


    private void createCallLog(String caption, int who) {
        String conversationType = "single";
        if (!TARGET_TYPE.equals("single"))
            conversationType = "group";

        String finalConversationType = conversationType;
        FirebaseUtils.ref.INSTANCE.user(TARGET_UID)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists() && dataSnapshot.hasChildren()) {
                            String targetNumber = Objects.requireNonNull(dataSnapshot.child("phone").getValue()).toString();
                            String myNumber = FirebaseUtils.INSTANCE.getPhoneNumber();

                            FirebaseUtils.INSTANCE.setCallLog(myUid, TARGET_UID, finalConversationType,
                                    targetNumber, caption, "call_log_from");

                            if (who == 2){
                                FirebaseUtils.INSTANCE.setCallLog(TARGET_UID, myUid, finalConversationType,
                                        myNumber, caption, "call_log_to");
                            }

                        } else {
                            FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid())
                                    .removeValue();
                        }
                        abort();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }

    private void abort() {
        if (TARGET_TYPE.equals("single")) {
            deleteNodeFromDatabase(FirebaseUtils.INSTANCE.getUid());
            deleteNodeFromDatabase(TARGET_UID);
        } else {
            deleteNodeFromDatabase(FirebaseUtils.INSTANCE.getUid());
        }
    }

    private static void deleteNodeFromDatabase(String uid) {
        FirebaseUtils.ref.INSTANCE.callRef(uid).removeValue()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Timber.d("onComplete: " + uid + " call_info deleted successfully...");
                    }
                });
    }


    public static String getDurationBreakdown(long millis) {
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);


        if (days > 0) {
            sb.append(days);
            sb.append(" Days ");
        }
        if (hours > 0) {
            sb.append(hours);
            sb.append(" Hrs ");
        }
        if (minutes > 0) {
            sb.append(minutes);
            sb.append(" Min ");
        }
        if (seconds > 0) {
            sb.append(seconds);
            sb.append(" Sec ");
        }

        return (sb.toString());
    }


    private void joinMeToCallNow() {
        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                .setRoom(call_id)
                .setWelcomePageEnabled(true)
                .setAudioOnly(false)
                .build();
        JitsiMeetActivity.launch(OutgoingCallActivity.this, String.valueOf(options));
    }




    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            // start the animation
            animationDrawable.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            // stop the animation
            animationDrawable.stop();
        }
    }

}