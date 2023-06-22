package ca.scooter.talkufy.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020 2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0016J0\u0010,\u001a\u00020 2\u0006\u0010\t\u001a\u00020-2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001aH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u00064"}, d2 = {"Lca/scooter/talkufy/activities/EditProfile;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "context", "getContext", "()Lca/scooter/talkufy/activities/EditProfile;", "imageFile", "Ljava/io/File;", "getImageFile", "()Ljava/io/File;", "setImageFile", "(Ljava/io/File;)V", "isForAccountCreation", "", "()Z", "setForAccountCreation", "(Z)V", "isProfileChanged", "setProfileChanged", "myUID", "", "getMyUID", "()Ljava/lang/String;", "setMyUID", "(Ljava/lang/String;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "uploadProfilePic", "Landroid/content/Context;", "file", "storageRef", "Lcom/google/firebase/storage/StorageReference;", "dbRef", "Lcom/google/firebase/database/DatabaseReference;", "toastAfterUploadIfAny", "app_debug"})
public final class EditProfile extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private java.lang.String myUID;
    @org.jetbrains.annotations.NotNull
    private final ca.scooter.talkufy.activities.EditProfile context = null;
    private boolean isProfileChanged = false;
    public android.graphics.Bitmap bitmap;
    public java.io.File imageFile;
    private boolean isForAccountCreation = false;
    private java.util.HashMap _$_findViewCache;
    
    public EditProfile() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMyUID() {
        return null;
    }
    
    public final void setMyUID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final ca.scooter.talkufy.activities.EditProfile getContext() {
        return null;
    }
    
    public final boolean isProfileChanged() {
        return false;
    }
    
    public final void setProfileChanged(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.Bitmap getBitmap() {
        return null;
    }
    
    public final void setBitmap(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.io.File getImageFile() {
        return null;
    }
    
    public final void setImageFile(@org.jetbrains.annotations.NotNull
    java.io.File p0) {
    }
    
    public final boolean isForAccountCreation() {
        return false;
    }
    
    public final void setForAccountCreation(boolean p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void uploadProfilePic(android.content.Context context, java.io.File file, com.google.firebase.storage.StorageReference storageRef, com.google.firebase.database.DatabaseReference dbRef, java.lang.String toastAfterUploadIfAny) {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
}