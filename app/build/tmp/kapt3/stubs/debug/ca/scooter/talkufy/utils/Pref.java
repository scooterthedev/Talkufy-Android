package ca.scooter.talkufy.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\"#B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0016J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0004J\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0010J\u0016\u0010\u001e\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0016J\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lca/scooter/talkufy/utils/Pref;", "", "()V", "FILE_PROFILE", "", "FILE_SETTING", "KEY_CURRENT_TARGET", "KEY_DEFAULT_TRANSLATION_LANG", "KEY_MEDIA_VISIBILITY", "KEY_SOUND", "KEY_TAP_TO_REPLY", "KEY_VIBRATION", "getCurrentTargetUID", "context", "Landroid/content/Context;", "getDefaultLanguage", "", "defaultLanguage", "getSettingFile", "Landroid/content/SharedPreferences;", "getStoredToken", "isMediaVisible", "", "isTapToReply", "", "isEnabled", "setCurrentTargetUID", "targetUID", "setDefaultLanguage", "languageCode", "setMediaVisibility", "isVisible", "storeToken", "token", "Notification", "Profile", "app_debug"})
public final class Pref {
    @org.jetbrains.annotations.NotNull
    public static final ca.scooter.talkufy.utils.Pref INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_SOUND = "sound";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_VIBRATION = "vibration";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FILE_SETTING = "settings";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FILE_PROFILE = "profile";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_DEFAULT_TRANSLATION_LANG = "default_translation_language";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_TAP_TO_REPLY = "tap_to_reply";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_CURRENT_TARGET = "current";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_MEDIA_VISIBILITY = "media_visibility";
    
    private Pref() {
        super();
    }
    
    public final void storeToken(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getStoredToken(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final void setCurrentTargetUID(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String targetUID) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentTargetUID(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final void setMediaVisibility(@org.jetbrains.annotations.NotNull
    android.content.Context context, boolean isVisible) {
    }
    
    public final boolean isMediaVisible(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.SharedPreferences getSettingFile(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final boolean isTapToReply(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    public final void isTapToReply(@org.jetbrains.annotations.NotNull
    android.content.Context context, boolean isEnabled) {
    }
    
    public final void setDefaultLanguage(@org.jetbrains.annotations.NotNull
    android.content.Context context, int languageCode) {
    }
    
    public final int getDefaultLanguage(@org.jetbrains.annotations.NotNull
    android.content.Context context, int defaultLanguage) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lca/scooter/talkufy/utils/Pref$Notification;", "", "()V", "hasSoundEnabled", "", "context", "Landroid/content/Context;", "hasVibrationEnabled", "setSoundEnabled", "", "isEnabled", "setVibrationEnabled", "app_debug"})
    public static final class Notification {
        @org.jetbrains.annotations.NotNull
        public static final ca.scooter.talkufy.utils.Pref.Notification INSTANCE = null;
        
        private Notification() {
            super();
        }
        
        public final void setSoundEnabled(@org.jetbrains.annotations.NotNull
        android.content.Context context, boolean isEnabled) {
        }
        
        public final void setVibrationEnabled(@org.jetbrains.annotations.NotNull
        android.content.Context context, boolean isEnabled) {
        }
        
        public final boolean hasSoundEnabled(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return false;
        }
        
        public final boolean hasVibrationEnabled(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lca/scooter/talkufy/utils/Pref$Profile;", "", "()V", "isProfileUrlSame", "", "context", "Landroid/content/Context;", "uid", "", "providedURL", "setProfileUrl", "", "url", "app_debug"})
    public static final class Profile {
        @org.jetbrains.annotations.NotNull
        public static final ca.scooter.talkufy.utils.Pref.Profile INSTANCE = null;
        
        private Profile() {
            super();
        }
        
        public final void setProfileUrl(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String uid, @org.jetbrains.annotations.NotNull
        java.lang.String url) {
        }
        
        public final boolean isProfileUrlSame(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String uid, @org.jetbrains.annotations.NotNull
        java.lang.String providedURL) {
            return false;
        }
    }
}