package ca.scooter.talkufy.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020#H\u0003J\b\u00102\u001a\u000200H\u0003J\u0010\u00103\u001a\u0002002\u0006\u00104\u001a\u000205H\u0016J&\u00106\u001a\u0004\u0018\u00010#2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020@H\u0003R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\u000e\u0010-\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"Lca/scooter/talkufy/fragments/FragmentOTP;", "Landroidx/fragment/app/Fragment;", "()V", "lastGenerated", "", "getLastGenerated", "()Ljava/lang/Long;", "setLastGenerated", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mResendToken", "Lcom/google/firebase/auth/PhoneAuthProvider$ForceResendingToken;", "getMResendToken", "()Lcom/google/firebase/auth/PhoneAuthProvider$ForceResendingToken;", "setMResendToken", "(Lcom/google/firebase/auth/PhoneAuthProvider$ForceResendingToken;)V", "mobile_no", "", "getMobile_no", "()Ljava/lang/String;", "setMobile_no", "(Ljava/lang/String;)V", "otp_count", "", "getOtp_count", "()I", "setOtp_count", "(I)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "rootView", "Landroid/view/View;", "userInfoBundle", "Landroid/os/Bundle;", "getUserInfoBundle", "()Landroid/os/Bundle;", "setUserInfoBundle", "(Landroid/os/Bundle;)V", "verificationID", "getVerificationID", "setVerificationID", "verificationStateChangedCallbacks", "Lcom/google/firebase/auth/PhoneAuthProvider$OnVerificationStateChangedCallbacks;", "bindViews", "", "view", "generateOTP", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "setValueAnimator", "duration", "signInWithCredential", "credential", "Lcom/google/firebase/auth/PhoneAuthCredential;", "app_debug"})
public final class FragmentOTP extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private java.lang.String mobile_no;
    @org.jetbrains.annotations.Nullable
    private java.lang.Long lastGenerated;
    @org.jetbrains.annotations.NotNull
    private java.lang.String verificationID = "";
    @org.jetbrains.annotations.Nullable
    private com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken mResendToken;
    @org.jetbrains.annotations.Nullable
    private android.os.Bundle userInfoBundle;
    @org.jetbrains.annotations.Nullable
    private android.app.ProgressDialog progressDialog;
    private int otp_count = 1;
    private android.view.View rootView;
    private com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks verificationStateChangedCallbacks;
    private java.util.HashMap _$_findViewCache;
    
    public FragmentOTP() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMobile_no() {
        return null;
    }
    
    public final void setMobile_no(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getLastGenerated() {
        return null;
    }
    
    public final void setLastGenerated(@org.jetbrains.annotations.Nullable
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getVerificationID() {
        return null;
    }
    
    public final void setVerificationID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken getMResendToken() {
        return null;
    }
    
    public final void setMResendToken(@org.jetbrains.annotations.Nullable
    com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.os.Bundle getUserInfoBundle() {
        return null;
    }
    
    public final void setUserInfoBundle(@org.jetbrains.annotations.Nullable
    android.os.Bundle p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.app.ProgressDialog getProgressDialog() {
        return null;
    }
    
    public final void setProgressDialog(@org.jetbrains.annotations.Nullable
    android.app.ProgressDialog p0) {
    }
    
    public final int getOtp_count() {
        return 0;
    }
    
    public final void setOtp_count(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @android.annotation.SuppressLint(value = {"CommitTransaction", "UseRequireInsteadOfGet"})
    private final void bindViews(android.view.View view) {
    }
    
    @android.annotation.SuppressLint(value = {"UseRequireInsteadOfGet"})
    private final void generateOTP() {
    }
    
    @android.annotation.SuppressLint(value = {"UseRequireInsteadOfGet"})
    private final void signInWithCredential(com.google.firebase.auth.PhoneAuthCredential credential) {
    }
    
    private final void setValueAnimator(long duration) {
    }
}