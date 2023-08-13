package ca.scooter.talkufy.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\"\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\nH\u0014J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\'H\u0016J-\u0010(\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-H\u0016\u00a2\u0006\u0002\u0010.R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016\u00a8\u00060"}, d2 = {"Lca/scooter/talkufy/activities/ContactsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lca/scooter/talkufy/activities/ContactsActivity$ViewHolder;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "asyncLoader", "Ljava/util/concurrent/Future;", "", "isForSelection", "", "()Z", "setForSelection", "(Z)V", "numberList", "", "Lca/scooter/talkufy/models/Models$Contact;", "getNumberList", "()Ljava/util/List;", "setNumberList", "(Ljava/util/List;)V", "registeredAvailableUser", "getRegisteredAvailableUser", "setRegisteredAvailableUser", "loadRegisteredUsers", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "ViewHolder", "app_debug"})
public final class ContactsActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.Contact> numberList;
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.Contact> registeredAvailableUser;
    private boolean isForSelection = false;
    private java.util.concurrent.Future<kotlin.Unit> asyncLoader;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.RecyclerView.Adapter<ca.scooter.talkufy.activities.ContactsActivity.ViewHolder> adapter = null;
    private java.util.HashMap _$_findViewCache;
    
    public ContactsActivity() {
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
    
    public final boolean isForSelection() {
        return false;
    }
    
    public final void setForSelection(boolean p0) {
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
    
    private final void loadRegisteredUsers() {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView.Adapter<ca.scooter.talkufy.activities.ContactsActivity.ViewHolder> getAdapter() {
        return null;
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lca/scooter/talkufy/activities/ContactsActivity$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getName", "()Landroid/widget/TextView;", "number", "getNumber", "pic", "Lde/hdodenhof/circleimageview/CircleImageView;", "getPic", "()Lde/hdodenhof/circleimageview/CircleImageView;", "time", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView name = null;
        private final android.widget.TextView number = null;
        private final de.hdodenhof.circleimageview.CircleImageView pic = null;
        private final android.widget.TextView time = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final android.widget.TextView getName() {
            return null;
        }
        
        public final android.widget.TextView getNumber() {
            return null;
        }
        
        public final de.hdodenhof.circleimageview.CircleImageView getPic() {
            return null;
        }
    }
}