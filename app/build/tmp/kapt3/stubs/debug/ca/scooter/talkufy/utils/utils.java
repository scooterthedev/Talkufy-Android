package ca.scooter.talkufy.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001aB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0017J\u0016\u0010\"\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010$\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u001a\u0010\'\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010(\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010)\u001a\u00020&2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0017J\u0018\u0010+\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010,\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010-\u001a\u00020\bJ\u000e\u0010.\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00100\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00101\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006J\u001f\u00102\u001a\u00020\u00042\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020504\"\u000205\u00a2\u0006\u0002\u00106J\u000e\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u000209J\u001e\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020\bJ\u000e\u0010C\u001a\u00020/2\u0006\u0010B\u001a\u00020\bJ\u001e\u0010D\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\bJ\u0018\u0010H\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020MJ \u0010N\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ \u0010O\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ \u0010P\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ \u0010Q\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010R\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010S\u001a\u0004\u0018\u00010T2\u0006\u00108\u001a\u0002092\u0006\u0010U\u001a\u00020VJ\u0010\u0010W\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020VJ\u001e\u0010X\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\b2\u0006\u0010E\u001a\u00020FJ\u000e\u0010Z\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001f\u0010[\u001a\u00020\u00042\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020504\"\u000205\u00a2\u0006\u0002\u00106J\u000e\u0010\\\u001a\u00020\u00042\u0006\u0010U\u001a\u00020VJ\u000e\u0010]\u001a\u00020\u00042\u0006\u0010U\u001a\u00020VJ\u0016\u0010^\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\bJ\u0018\u0010_\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010I\u001a\u00020JJ\u000e\u0010`\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010H\u001a\u00020\u0004*\u00020\u00062\u0006\u0010I\u001a\u00020\bJ\u0012\u0010_\u001a\u00020\u0004*\u00020\u00062\u0006\u0010I\u001a\u00020\b\u00a8\u0006b"}, d2 = {"Lca/scooter/talkufy/utils/utils;", "", "()V", "addVideoToMediaStore", "", "context", "Landroid/content/Context;", "messageIdForName", "", "file", "Ljava/io/File;", "getBitmapFromByteArray", "Landroid/graphics/Bitmap;", "byteArray", "", "getByteArrayFromBitmap", "bitmap", "getCircleBitmap", "getContactList", "", "Lca/scooter/talkufy/models/Models$Contact;", "getDurationString", "duration", "", "getFileExtension", "getFileSize", "sizeInBytes", "getFormattedTenDigitNumber", "number", "getHeaderFormattedDate", "timeInMillis", "getLocalDate", "getLocalDateWithYear", "getLocalTime", "getNameFromNumber", "getProfilePicPath", "getRealPathFromURI", "contentUri", "Landroid/net/Uri;", "getReceivedBitmapFile", "getSentBitmapFile", "getUriFromFile", "getUtcTimeFromMillis", "getVideoFile", "getVideoLength", "videoFilePath", "hasCallPermission", "", "hasContactPermission", "hasStoragePermission", "hideFabs", "fabs", "", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "([Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V", "hideSoftKeyboard", "activity", "Landroid/app/Activity;", "highlightTextView", "textView", "Landroid/widget/TextView;", "highlightedText", "color", "", "isAppIsInBackground", "isChannelID", "id", "isGroupID", "loadVideoThumbnailFromLocalAsync", "imageView", "Landroid/widget/ImageView;", "path", "longToast", "message", "", "printIntentKeyValues", "intent", "Landroid/content/Intent;", "saveBitmapToProfileFolder", "saveBitmapToReceived", "saveBitmapToSent", "saveVideo", "fileBytes", "setEnterRevealEffect", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "setExitRevealEffect", "setVideoThumbnailFromWebAsync", "videoPath", "shareInviteText", "showFabs", "slideDown", "slideUp", "startVideoIntent", "toast", "vibrate", "constants", "app_debug"})
public final class utils {
    @org.jetbrains.annotations.NotNull
    public static final ca.scooter.talkufy.utils.utils INSTANCE = null;
    
    private utils() {
        super();
    }
    
    public final boolean isGroupID(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return false;
    }
    
    public final boolean isChannelID(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return false;
    }
    
    public final void toast(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.CharSequence message) {
    }
    
    public final void longToast(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.CharSequence message) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedTenDigitNumber(@org.jetbrains.annotations.NotNull
    java.lang.String number) {
        return null;
    }
    
    public final void printIntentKeyValues(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.Contact> getContactList(@org.jetbrains.annotations.Nullable
    android.content.Context context) {
        return null;
    }
    
    public final boolean hasContactPermission(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    public final boolean hasCallPermission(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    public final boolean hasStoragePermission(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocalTime(long timeInMillis) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocalDate(long timeInMillis) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocalDateWithYear(long timeInMillis) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHeaderFormattedDate(long timeInMillis) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUtcTimeFromMillis(long timeInMillis) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] getByteArrayFromBitmap(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.Bitmap getBitmapFromByteArray(@org.jetbrains.annotations.NotNull
    byte[] byteArray) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.animation.Animator setEnterRevealEffect(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    android.view.View view) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.animation.Animator setExitRevealEffect(@org.jetbrains.annotations.NotNull
    android.view.View view) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String saveBitmapToSent(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull
    java.lang.String messageIdForName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProfilePicPath(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String saveBitmapToProfileFolder(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull
    java.lang.String messageIdForName) {
        return null;
    }
    
    private final java.io.File getSentBitmapFile(android.content.Context context, java.lang.String messageIdForName) {
        return null;
    }
    
    private final java.io.File getReceivedBitmapFile(android.content.Context context, java.lang.String messageIdForName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String saveBitmapToReceived(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull
    java.lang.String messageIdForName) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getVideoLength(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String videoFilePath) {
        return null;
    }
    
    public final void startVideoIntent(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String videoPath) {
    }
    
    private final java.lang.String getDurationString(long duration) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFileSize(long sizeInBytes) {
        return null;
    }
    
    public final void setVideoThumbnailFromWebAsync(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String videoPath, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    public final void loadVideoThumbnailFromLocalAsync(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull
    java.lang.String path) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.io.File getVideoFile(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String messageIdForName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String saveVideo(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    byte[] fileBytes, @org.jetbrains.annotations.NotNull
    java.lang.String messageIdForName) {
        return null;
    }
    
    public final void addVideoToMediaStore(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String messageIdForName, @org.jetbrains.annotations.NotNull
    java.io.File file) {
    }
    
    public final void highlightTextView(@org.jetbrains.annotations.NotNull
    android.widget.TextView textView, @org.jetbrains.annotations.NotNull
    java.lang.String highlightedText, int color) {
    }
    
    public final void hideSoftKeyboard(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.net.Uri getUriFromFile(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.io.File file) {
        return null;
    }
    
    public final boolean isAppIsInBackground(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNameFromNumber(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String number) {
        return null;
    }
    
    public final void vibrate(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void hideFabs(@org.jetbrains.annotations.NotNull
    com.google.android.material.floatingactionbutton.FloatingActionButton... fabs) {
    }
    
    public final void showFabs(@org.jetbrains.annotations.NotNull
    com.google.android.material.floatingactionbutton.FloatingActionButton... fabs) {
    }
    
    public final void shareInviteText(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRealPathFromURI(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.net.Uri contentUri) {
        return null;
    }
    
    public final void toast(@org.jetbrains.annotations.NotNull
    android.content.Context $this$toast, @org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    public final void longToast(@org.jetbrains.annotations.NotNull
    android.content.Context $this$longToast, @org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.Bitmap getCircleBitmap(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFileExtension(@org.jetbrains.annotations.NotNull
    java.io.File file) {
        return null;
    }
    
    public final void slideUp(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    public final void slideDown(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lca/scooter/talkufy/utils/utils$constants;", "", "()V", "APP_LINK", "", "APP_SHORT_LINK", "CALL_STATUS_ANOTHER_CALL", "CALL_STATUS_ANSWERED", "CALL_STATUS_BUSY", "CALL_STATUS_CALLING", "CALL_STATUS_CALL_ENDED", "CALL_STATUS_CALL_JOINED", "CALL_STATUS_REJECTED", "CALL_STATUS_RINGING", "FILE_TYPE_IMAGE", "FILE_TYPE_LOCATION", "FILE_TYPE_VIDEO", "IS_FOR_SINGLE_FILE", "KEY_ADDRESS", "KEY_CAPTION", "KEY_EXCLUDED_LIST", "KEY_FILE_TYPE", "KEY_IMG_PATH", "KEY_IS_CHANNEL", "KEY_IS_FOR_SELECTION", "KEY_IS_GROUP", "KEY_IS_ONCE", "KEY_IS_ON_ACCOUNT_CREATION", "KEY_LATITUDE", "KEY_LOCAL_PATH", "KEY_LONGITUDE", "KEY_MSG_MODEL", "KEY_NAME", "KEY_NAME_OR_NUMBER", "KEY_SELECTED", "KEY_TARGET_TYPE", "KEY_UNREAD", "PHONE_STATE_IDLE", "PHONE_STATE_INCOMING_CALL", "PHONE_STATE_ONGOING_CALL", "REGEX_PATTERN_PHONE", "SHARING_TEXT", "URI_AUTHORITY", "debugUserID", "app_debug"})
    public static final class constants {
        @org.jetbrains.annotations.NotNull
        public static final ca.scooter.talkufy.utils.utils.constants INSTANCE = null;
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String FILE_TYPE_IMAGE = "image";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String FILE_TYPE_LOCATION = "location";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String FILE_TYPE_VIDEO = "video";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_IMG_PATH = "path";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_CAPTION = "caption";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_LOCAL_PATH = "local_path";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_TARGET_TYPE = "target_type";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_NAME_OR_NUMBER = "name_or_number";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_SELECTED = "selected";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_IS_GROUP = "isGroup";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_IS_CHANNEL = "isChannel";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_EXCLUDED_LIST = "excluded_list";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_IS_ON_ACCOUNT_CREATION = "on_acc_creation";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_IS_ONCE = "is_once";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_IS_FOR_SELECTION = "for_selection";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_MSG_MODEL = "msg_model";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_LATITUDE = "lat";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_LONGITUDE = "lng";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_ADDRESS = "address";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_NAME = "name";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String IS_FOR_SINGLE_FILE = "isSingleFile";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String URI_AUTHORITY = "com.mvc.imagepicker.provider";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_FILE_TYPE = "type";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String debugUserID = "";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_UNREAD = "unread";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String REGEX_PATTERN_PHONE = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String PHONE_STATE_INCOMING_CALL = "incoming_call";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String PHONE_STATE_ONGOING_CALL = "ongoing_call";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String PHONE_STATE_IDLE = "phone_idle";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CALL_STATUS_CALLING = "Calling";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CALL_STATUS_REJECTED = "Rejected";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CALL_STATUS_ANSWERED = "Answered";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CALL_STATUS_RINGING = "Ringing";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CALL_STATUS_BUSY = "Busy";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CALL_STATUS_ANOTHER_CALL = "Another_Call";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CALL_STATUS_CALL_ENDED = "Call_Ended";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CALL_STATUS_CALL_JOINED = "Joined";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String APP_SHORT_LINK = "https://goo.gl/TzQgdm";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String APP_LINK = "https://play.google.com/store/apps/details?id=androidx.multidex";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String SHARING_TEXT = "Download Talkufy - A completely free & realtime call ,chat, etc app, for me I use it to connect to my family";
        
        private constants() {
            super();
        }
    }
}