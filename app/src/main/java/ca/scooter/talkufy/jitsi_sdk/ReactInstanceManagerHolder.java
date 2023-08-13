//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ca.scooter.talkufy.jitsi_sdk;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.Nullable;

import com.BV.LinearGradient.LinearGradientPackage;
import com.calendarevents.CalendarEventsPackage;
import com.corbt.keepawake.KCKeepAwakePackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.shell.MainReactPackage;
import com.ocetnik.timer.BackgroundTimerPackage;
import com.oney.WebRTCModule.WebRTCModulePackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.rnimmersive.RNImmersivePackage;
import com.zmxv.RNSound.RNSoundPackage;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.scooter.talkufy.jitsi_sdk.net.NAT64AddrInfoModule;

class ReactInstanceManagerHolder {
    private static ReactInstanceManager reactInstanceManager;

    ReactInstanceManagerHolder() {
    }

    private static List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> nativeModules = new ArrayList(Arrays.asList(new ca.scooter.talkufy.jitsi_sdk.AndroidSettingsModule(reactContext), new AppInfoModule(reactContext), new AudioModeModule(reactContext), new DropboxModule(reactContext), new ExternalAPIModule(reactContext), new LocaleDetector(reactContext), new PictureInPictureModule(reactContext), new ProximityModule(reactContext), new WiFiStatsModule(reactContext), new NAT64AddrInfoModule(reactContext)));
        if (AudioModeModule.useConnectionService()) {
            nativeModules.add(new RNConnectionService(reactContext));
        }

        try {
            Class<?> amplitudeModuleClass = Class.forName("AmplitudeModule");
            Constructor constructor = amplitudeModuleClass.getConstructor(ReactApplicationContext.class);
            nativeModules.add((NativeModule)constructor.newInstance(reactContext));
        } catch (Exception var4) {
        }

        return nativeModules;
    }

    static void emitEvent(String eventName, @Nullable Object data) {
        ReactInstanceManager reactInstanceManager = getReactInstanceManager();
        if (reactInstanceManager != null) {
            ReactContext reactContext = reactInstanceManager.getCurrentReactContext();
            if (reactContext != null) {
                reactContext.getJSModule(RCTDeviceEventEmitter.class).emit(eventName, data);
            }
        }

    }

    static <T extends NativeModule> T getNativeModule(Class<T> nativeModuleClass) {
        ReactContext reactContext = reactInstanceManager != null ? reactInstanceManager.getCurrentReactContext() : null;
        return reactContext != null ? reactContext.getNativeModule(nativeModuleClass) : null;
    }

    static Activity getCurrentActivity() {
        ReactContext reactContext = reactInstanceManager != null ? reactInstanceManager.getCurrentReactContext() : null;
        return reactContext != null ? reactContext.getCurrentActivity() : null;
    }

    static ReactInstanceManager getReactInstanceManager() {
        return reactInstanceManager;
    }

    static void initReactInstanceManager(Application application) {
        if (reactInstanceManager == null) {
            ArrayList packages = new ArrayList(Arrays.asList(new LinearGradientPackage(), new CalendarEventsPackage(), new KCKeepAwakePackage(), new ca.scooter.talkufy.jitsi_sdk.FastImageViewPackage(), new MainReactPackage(), new VectorIconsPackage(), new BackgroundTimerPackage(), new WebRTCModulePackage(), new AsyncStoragePackage(), new RNCWebViewPackage(), new RNImmersivePackage(), new RNSoundPackage(), new ReactPackageAdapter() {
                public @NotNull List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
                    return ReactInstanceManagerHolder.createNativeModules(reactContext);
                }
            }));

            try {
                Class<?> googlePackageClass = Class.forName("co.apptailor.googlesignin.RNGoogleSigninPackage");
                Constructor constructor = googlePackageClass.getConstructor();
                packages.add(constructor.newInstance());
            } catch (Exception var4) {
            }

            reactInstanceManager = ReactInstanceManager.builder().setApplication(application).setBundleAssetName("index.android.bundle").setJSMainModulePath("index.android").addPackages(packages).setUseDeveloperSupport(false).setInitialLifecycleState(LifecycleState.RESUMED).build();
            DevInternalSettings devSettings = (DevInternalSettings)reactInstanceManager.getDevSupportManager().getDevSettings();
            if (devSettings != null) {
                devSettings.setBundleDeltasEnabled(false);
            }

            JitsiMeetUncaughtExceptionHandler.register();
        }
    }
}
