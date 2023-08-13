package ca.scooter.talkufy.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001=B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001fH\u0002J\"\u0010\'\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0012\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0012\u00100\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000205H\u0016J$\u00106\u001a\u00020%2\u001a\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u000108j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`9H\u0002J\u0018\u0010:\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001fH\u0002J\u0010\u0010<\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006>"}, d2 = {"Lca/scooter/talkufy/activities/CreateChannelActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "context", "getContext", "()Lca/scooter/talkufy/activities/CreateChannelActivity;", "imageFile", "Ljava/io/File;", "getImageFile", "()Ljava/io/File;", "setImageFile", "(Ljava/io/File;)V", "isProfileChanged", "", "()Z", "setProfileChanged", "(Z)V", "participantList", "", "Lca/scooter/talkufy/models/Models$Contact;", "getParticipantList", "()Ljava/util/List;", "setParticipantList", "(Ljava/util/List;)V", "profileURL", "", "getProfileURL", "()Ljava/lang/String;", "setProfileURL", "(Ljava/lang/String;)V", "createChannel", "", "channelID", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setGridAdapter", "selectedUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateProfileUrl", "url", "uploadChannelProfilePicAndCreateChannel", "ParticipantHolder", "app_debug"})
public final class CreateChannelActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.Contact> participantList;
    private boolean isProfileChanged = false;
    public android.graphics.Bitmap bitmap;
    @org.jetbrains.annotations.NotNull
    private java.lang.String profileURL = "";
    public java.io.File imageFile;
    @org.jetbrains.annotations.NotNull
    private final ca.scooter.talkufy.activities.CreateChannelActivity context = null;
    private java.util.HashMap _$_findViewCache;
    
    public CreateChannelActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.Contact> getParticipantList() {
        return null;
    }
    
    public final void setParticipantList(@org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.Contact> p0) {
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
    public final java.lang.String getProfileURL() {
        return null;
    }
    
    public final void setProfileURL(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.io.File getImageFile() {
        return null;
    }
    
    public final void setImageFile(@org.jetbrains.annotations.NotNull
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final ca.scooter.talkufy.activities.CreateChannelActivity getContext() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setGridAdapter(java.util.ArrayList<ca.scooter.talkufy.models.Models.Contact> selectedUsers) {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void createChannel(java.lang.String channelID) {
    }
    
    private final void uploadChannelProfilePicAndCreateChannel(java.lang.String channelID) {
    }
    
    private final void updateProfileUrl(java.lang.String channelID, java.lang.String url) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lca/scooter/talkufy/activities/CreateChannelActivity$ParticipantHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "cancelBtn", "Lde/hdodenhof/circleimageview/CircleImageView;", "getCancelBtn", "()Lde/hdodenhof/circleimageview/CircleImageView;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "pic", "getPic", "app_debug"})
    public static final class ParticipantHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView name = null;
        @org.jetbrains.annotations.NotNull
        private final de.hdodenhof.circleimageview.CircleImageView pic = null;
        @org.jetbrains.annotations.NotNull
        private final de.hdodenhof.circleimageview.CircleImageView cancelBtn = null;
        
        public ParticipantHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final de.hdodenhof.circleimageview.CircleImageView getPic() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final de.hdodenhof.circleimageview.CircleImageView getCancelBtn() {
            return null;
        }
    }
}