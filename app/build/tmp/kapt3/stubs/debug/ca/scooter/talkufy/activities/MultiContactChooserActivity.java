package ca.scooter.talkufy.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u000234B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020\nH\u0014J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0016J-\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-2\u000e\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0/2\u0006\u00100\u001a\u000201H\u0016\u00a2\u0006\u0002\u00102R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011\u00a8\u00065"}, d2 = {"Lca/scooter/talkufy/activities/MultiContactChooserActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lca/scooter/talkufy/activities/MultiContactChooserActivity$ViewHolder;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "asyncLoader", "Ljava/util/concurrent/Future;", "", "excludedUIDs", "", "", "getExcludedUIDs", "()Ljava/util/List;", "setExcludedUIDs", "(Ljava/util/List;)V", "horizontalAdapter", "Lca/scooter/talkufy/activities/MultiContactChooserActivity$ParticipantHolder;", "getHorizontalAdapter", "numberList", "Lca/scooter/talkufy/models/Models$Contact;", "getNumberList", "setNumberList", "registeredAvailableUser", "getRegisteredAvailableUser", "setRegisteredAvailableUser", "selectedUsers", "getSelectedUsers", "setSelectedUsers", "loadRegisteredUsers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "ParticipantHolder", "ViewHolder", "app_debug"})
public final class MultiContactChooserActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.Contact> numberList;
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.Contact> registeredAvailableUser;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.String> excludedUIDs;
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.Contact> selectedUsers;
    private java.util.concurrent.Future<kotlin.Unit> asyncLoader;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.RecyclerView.Adapter<ca.scooter.talkufy.activities.MultiContactChooserActivity.ViewHolder> adapter = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.RecyclerView.Adapter<ca.scooter.talkufy.activities.MultiContactChooserActivity.ParticipantHolder> horizontalAdapter = null;
    private java.util.HashMap _$_findViewCache;
    
    public MultiContactChooserActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.Contact> getNumberList() {
        return null;
    }
    
    public final void setNumberList(@org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.Contact> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.Contact> getRegisteredAvailableUser() {
        return null;
    }
    
    public final void setRegisteredAvailableUser(@org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.Contact> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getExcludedUIDs() {
        return null;
    }
    
    public final void setExcludedUIDs(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.Contact> getSelectedUsers() {
        return null;
    }
    
    public final void setSelectedUsers(@org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.Contact> p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
    }
    
    private final void loadRegisteredUsers() {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView.Adapter<ca.scooter.talkufy.activities.MultiContactChooserActivity.ViewHolder> getAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView.Adapter<ca.scooter.talkufy.activities.MultiContactChooserActivity.ParticipantHolder> getHorizontalAdapter() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lca/scooter/talkufy/activities/MultiContactChooserActivity$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Lcom/github/lguipeng/library/animcheckbox/AnimCheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Lcom/github/lguipeng/library/animcheckbox/AnimCheckBox;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "pic", "Lde/hdodenhof/circleimageview/CircleImageView;", "getPic", "()Lde/hdodenhof/circleimageview/CircleImageView;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView name = null;
        private final de.hdodenhof.circleimageview.CircleImageView pic = null;
        private final com.github.lguipeng.library.animcheckbox.AnimCheckBox checkBox = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final android.widget.TextView getName() {
            return null;
        }
        
        public final de.hdodenhof.circleimageview.CircleImageView getPic() {
            return null;
        }
        
        public final com.github.lguipeng.library.animcheckbox.AnimCheckBox getCheckBox() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lca/scooter/talkufy/activities/MultiContactChooserActivity$ParticipantHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "pic", "Lde/hdodenhof/circleimageview/CircleImageView;", "getPic", "()Lde/hdodenhof/circleimageview/CircleImageView;", "app_debug"})
    public static final class ParticipantHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView name = null;
        @org.jetbrains.annotations.NotNull
        private final de.hdodenhof.circleimageview.CircleImageView pic = null;
        
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
    }
}