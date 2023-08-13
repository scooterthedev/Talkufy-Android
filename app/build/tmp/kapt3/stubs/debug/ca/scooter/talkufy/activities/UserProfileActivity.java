package ca.scooter.talkufy.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002VWB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\b\u00106\u001a\u000204H\u0002J\b\u00107\u001a\u000204H\u0002J\b\u00108\u001a\u000204H\u0002J\"\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010>H\u0014J\u0012\u0010?\u001a\u0002042\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\u0012\u0010B\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u000204H\u0014J\u0010\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020HH\u0016J\u0016\u0010I\u001a\u0002042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0016\u0010J\u001a\u0002042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\fH\u0002J\b\u0010K\u001a\u000204H\u0002J\b\u0010L\u001a\u000204H\u0002J\u0018\u0010M\u001a\u0002042\u0006\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020(H\u0002J\u0018\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u00020(2\u0006\u0010O\u001a\u00020(H\u0002J\u0018\u0010R\u001a\u0002042\u0006\u0010N\u001a\u00020(2\u0006\u0010S\u001a\u00020TH\u0002J\u0018\u0010U\u001a\u0002042\u0006\u0010Q\u001a\u00020(2\u0006\u0010S\u001a\u00020TH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000fR\u001a\u0010\'\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001a\u00100\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,\u00a8\u0006X"}, d2 = {"Lca/scooter/talkufy/activities/UserProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "amIAdmin", "", "getAmIAdmin", "()Z", "setAmIAdmin", "(Z)V", "asyncLoader", "Ljava/util/concurrent/Future;", "channelMembers", "", "Lca/scooter/talkufy/models/Models$ChannelMember;", "getChannelMembers", "()Ljava/util/List;", "setChannelMembers", "(Ljava/util/List;)V", "channel_is_Public", "getChannel_is_Public", "setChannel_is_Public", "context", "getContext", "()Lca/scooter/talkufy/activities/UserProfileActivity;", "groupMembers", "Lca/scooter/talkufy/models/Models$GroupMember;", "getGroupMembers", "setGroupMembers", "isBlockedByMe", "setBlockedByMe", "isChannel", "setChannel", "isGroup", "setGroup", "isPhoneLoaded", "setPhoneLoaded", "messageModels", "Lca/scooter/talkufy/models/Models$MessageModel;", "getMessageModels", "myUID", "", "getMyUID", "()Ljava/lang/String;", "setMyUID", "(Ljava/lang/String;)V", "name", "getName", "setName", "targetUID", "getTargetUID", "setTargetUID", "checkChannelPrivacy", "", "checkIfBlocked", "checkIfMeAdmin", "loadChannelMembers", "loadGroupMembers", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setChannelMemberAdapter", "setGroupMemberAdapter", "showChannelNameEditDialog", "showGroupNameEditDialog", "updateChannelProfileUrl", "channelID", "url", "updateGroupProfileUrl", "groupID", "uploadChannelProfilePic", "imageFile", "Ljava/io/File;", "uploadGroupProfilePic", "imageHolder", "videoHolder", "app_debug"})
public final class UserProfileActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<ca.scooter.talkufy.models.Models.MessageModel> messageModels = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String myUID = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String targetUID = "";
    private boolean isBlockedByMe = false;
    private boolean isPhoneLoaded = false;
    @org.jetbrains.annotations.NotNull
    private java.lang.String name = "";
    private boolean isGroup = false;
    private boolean isChannel = false;
    private boolean amIAdmin = false;
    private boolean channel_is_Public = false;
    private java.util.concurrent.Future<java.lang.Boolean> asyncLoader;
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.GroupMember> groupMembers;
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.ChannelMember> channelMembers;
    @org.jetbrains.annotations.NotNull
    private final ca.scooter.talkufy.activities.UserProfileActivity context = null;
    private java.util.HashMap _$_findViewCache;
    
    public UserProfileActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.MessageModel> getMessageModels() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMyUID() {
        return null;
    }
    
    public final void setMyUID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTargetUID() {
        return null;
    }
    
    public final void setTargetUID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean isBlockedByMe() {
        return false;
    }
    
    public final void setBlockedByMe(boolean p0) {
    }
    
    public final boolean isPhoneLoaded() {
        return false;
    }
    
    public final void setPhoneLoaded(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean isGroup() {
        return false;
    }
    
    public final void setGroup(boolean p0) {
    }
    
    public final boolean isChannel() {
        return false;
    }
    
    public final void setChannel(boolean p0) {
    }
    
    public final boolean getAmIAdmin() {
        return false;
    }
    
    public final void setAmIAdmin(boolean p0) {
    }
    
    public final boolean getChannel_is_Public() {
        return false;
    }
    
    public final void setChannel_is_Public(boolean p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
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
    
    private final void checkIfBlocked() {
    }
    
    private final void checkIfMeAdmin() {
    }
    
    private final void checkChannelPrivacy() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.GroupMember> getGroupMembers() {
        return null;
    }
    
    public final void setGroupMembers(@org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.GroupMember> p0) {
    }
    
    private final void loadGroupMembers() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.ChannelMember> getChannelMembers() {
        return null;
    }
    
    public final void setChannelMembers(@org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.ChannelMember> p0) {
    }
    
    private final void loadChannelMembers() {
    }
    
    private final void setGroupMemberAdapter(java.util.List<ca.scooter.talkufy.models.Models.GroupMember> groupMembers) {
    }
    
    private final void setChannelMemberAdapter(java.util.List<ca.scooter.talkufy.models.Models.ChannelMember> channelMembers) {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final ca.scooter.talkufy.activities.UserProfileActivity getContext() {
        return null;
    }
    
    private final void uploadGroupProfilePic(java.lang.String groupID, java.io.File imageFile) {
    }
    
    private final void uploadChannelProfilePic(java.lang.String channelID, java.io.File imageFile) {
    }
    
    private final void updateGroupProfileUrl(java.lang.String groupID, java.lang.String url) {
    }
    
    private final void updateChannelProfileUrl(java.lang.String channelID, java.lang.String url) {
    }
    
    private final void showGroupNameEditDialog() {
    }
    
    private final void showChannelNameEditDialog() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lca/scooter/talkufy/activities/UserProfileActivity$imageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getImageView", "()Landroid/widget/ImageView;", "app_debug"})
    public static final class imageHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.ImageView imageView = null;
        
        public imageHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final android.widget.ImageView getImageView() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lca/scooter/talkufy/activities/UserProfileActivity$videoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getImageView", "()Landroid/widget/ImageView;", "length", "Landroid/widget/TextView;", "getLength", "()Landroid/widget/TextView;", "app_debug"})
    public static final class videoHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.ImageView imageView = null;
        private final android.widget.TextView length = null;
        
        public videoHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final android.widget.ImageView getImageView() {
            return null;
        }
        
        public final android.widget.TextView getLength() {
            return null;
        }
    }
}