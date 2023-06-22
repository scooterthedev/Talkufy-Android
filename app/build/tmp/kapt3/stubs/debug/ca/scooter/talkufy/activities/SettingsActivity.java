package ca.scooter.talkufy.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0016\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u0013*\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002R\u0011\u0010\u0003\u001a\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\""}, d2 = {"Lca/scooter/talkufy/activities/SettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "context", "getContext", "()Lca/scooter/talkufy/activities/SettingsActivity;", "languageDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "getLanguageDialog", "()Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "setLanguageDialog", "(Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDefaultLanguageClick", "languages", "", "", "onLogoutClick", "view", "Landroid/view/View;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "bindLanguageDialog", "app_debug"})
public final class SettingsActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final ca.scooter.talkufy.activities.SettingsActivity context = null;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.bottomsheet.BottomSheetDialog languageDialog;
    private int selectedPosition = -1;
    private java.util.HashMap _$_findViewCache;
    
    public SettingsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final ca.scooter.talkufy.activities.SettingsActivity getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.bottomsheet.BottomSheetDialog getLanguageDialog() {
        return null;
    }
    
    public final void setLanguageDialog(@org.jetbrains.annotations.Nullable
    com.google.android.material.bottomsheet.BottomSheetDialog p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void onDefaultLanguageClick(java.util.List<java.lang.String> languages) {
    }
    
    public final int getSelectedPosition() {
        return 0;
    }
    
    public final void setSelectedPosition(int p0) {
    }
    
    private final void bindLanguageDialog(com.google.android.material.bottomsheet.BottomSheetDialog $this$bindLanguageDialog, java.util.List<java.lang.String> languages) {
    }
    
    public final void onLogoutClick(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
}