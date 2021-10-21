# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /user/local/Cellar/android-sdk/24.3.3/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

-keep public class com.dylanvann.fastimage.* {*;}
-keep public class com.dylanvann.fastimage.** {*;}
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
  }
  -keep public class * implements com.bumptech.glide.module.GlideModule
  -keep class * extends com.bumptech.glide.module.AppGlideModule {
   <init>(...);
  }
  -keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
  }
  -keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
    *** rewind();
  }

# React Native

# Keep our interfaces so they can be used by other ProGuard rules.
# See http://sourceforge.net/p/proguard/bugs/466/
-keep,allowobfuscation @interface com.facebook.proguard.annotations.DoNotStrip
-keep,allowobfuscation @interface com.facebook.proguard.annotations.KeepGettersAndSetters
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip

# Do not strip any method/class that is annotated with @DoNotStrip
-keep @com.facebook.proguard.annotations.DoNotStrip class *
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.proguard.annotations.DoNotStrip *;
    @com.facebook.common.internal.DoNotStrip *;
}

-keepclassmembers @com.facebook.proguard.annotations.KeepGettersAndSetters class * {
  void set*(***);
  *** get*();
}

-keep class * extends com.facebook.react.bridge.JavaScriptModule { *; }
-keep class * extends com.facebook.react.bridge.NativeModule { *; }
-keepclassmembers,includedescriptorclasses class * { native <methods>; }
-keepclassmembers class *  { #noinspection ShrinkerUnresolvedReference
 @com.facebook.react.uimanager.UIProp <fields>; }
-keepclassmembers class *  { @com.facebook.react.uimanager.annotations.ReactProp <methods>; }
-keepclassmembers class *  { @com.facebook.react.uimanager.annotations.ReactPropGroup <methods>; }

-dontwarn com.facebook.react.**
#noinspection ShrinkerUnresolvedReference
-keep,includedescriptorclasses class com.facebook.react.bridge.** { *; }

# okhttp

-keepattributes Signature
-keepattributes *Annotation*
#noinspection ShrinkerUnresolvedReference
-keep class okhttp3.** { *; }
#noinspection ShrinkerUnresolvedReference
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

# okio

#noinspection ShrinkerUnresolvedReference
-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
#noinspection ShrinkerUnresolvedReference
-keep class okio.** { *; }
-dontwarn okio.**

# WebRTC

#noinspection ShrinkerUnresolvedReference
-keep class org.webrtc.** { *; }
-dontwarn org.chromium.build.BuildHooksAndroid

# Jisti Meet SDK

#noinspection ShrinkerUnresolvedReference
-keep class org.jitsi.meet.** { *; }
#noinspection ShrinkerUnresolvedReference
-keep class org.jitsi.meet.sdk.** { *; }

# We added the following when we switched minifyEnabled on. Probably because we
# ran the app and hit problems...

-keep class com.facebook.react.bridge.CatalystInstanceImpl { *; }
#noinspection ShrinkerUnresolvedReference
-keep class com.facebook.react.bridge.ExecutorToken { *; }
-keep class com.facebook.react.bridge.JavaScriptExecutor { *; }
#noinspection ShrinkerUnresolvedReference
-keep class com.facebook.react.bridge.ModuleRegistryHolder { *; }
-keep class com.facebook.react.bridge.ReadableType { *; }
-keep class com.facebook.react.bridge.queue.NativeRunnable { *; }
#noinspection ShrinkerUnresolvedReference
-keep class com.facebook.react.devsupport.** { *; }

-dontwarn com.facebook.react.devsupport.**
-dontwarn com.google.appengine.**
-dontwarn com.squareup.okhttp.**
-dontwarn javax.servlet.**

# ^^^ I added the above when we switched minifyEnabled on.

# Rule to avoid build errors related to SVGs.
#noinspection ShrinkerUnresolvedReference
-keep public class com.horcrux.svg.** {*;}