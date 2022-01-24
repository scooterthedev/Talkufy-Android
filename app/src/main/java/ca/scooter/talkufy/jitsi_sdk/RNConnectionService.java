package ca.scooter.talkufy.jitsi_sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telecom.CallAudioState;
import android.telecom.Connection;
import android.telecom.DisconnectCause;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telecom.VideoProfile;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;


/**
 * The react-native side of Jitsi Meet's {@link ca.scooter.talkufy.jitsi_sdk.ConnectionService}. Exposes
 * the Java Script API.
 *
 * @author Pawel Domas
 */
@RequiresApi(api = Build.VERSION_CODES.O)
@ReactModule(name = RNConnectionService.NAME)
class RNConnectionService
    extends ReactContextBaseJavaModule {

    public static final String NAME = "ConnectionService";

    private static final String TAG = ca.scooter.talkufy.jitsi_sdk.ConnectionService.TAG;

    /**
     * Sets the audio route on all existing {@link Connection}s
     *
     * @param audioRoute the new audio route to be set. See
     * {@link CallAudioState} constants prefixed with "ROUTE_".
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    static void setAudioRoute(int audioRoute) {
        for (ca.scooter.talkufy.jitsi_sdk.ConnectionService.ConnectionImpl c
                : ca.scooter.talkufy.jitsi_sdk.ConnectionService.getConnections()) {
            c.setAudioRoute(audioRoute);
        }
    }

    RNConnectionService(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * Starts a new outgoing call.
     *
     * @param callUUID - unique call identifier assigned by Jitsi Meet to
     *        a conference call.
     * @param handle - a call handle which by default is Jitsi Meet room's URL.
     * @param hasVideo - whether or not user starts with the video turned on.
     * @param promise - the Promise instance passed by the React-native bridge,
     *        so that this method returns a Promise on the JS side.
     *
     * NOTE regarding the "missingPermission" suppress - SecurityException will
     * be handled as part of the Exception try catch block and the Promise will
     * be rejected.
     */
    @SuppressLint("MissingPermission")
    @ReactMethod
    public void startCall(
            String callUUID,
            String handle,
            boolean hasVideo,
            Promise promise) {
        Log.d(TAG,
              String.format("startCall UUID=%s, h=%s, v=%s",
                            callUUID,
                            handle,
                            hasVideo));

        ReactApplicationContext ctx = getReactApplicationContext();

        Uri address = Uri.fromParts(PhoneAccount.SCHEME_SIP, handle, null);
        PhoneAccountHandle accountHandle
            = ca.scooter.talkufy.jitsi_sdk.ConnectionService.registerPhoneAccount(
                    getReactApplicationContext(), address, callUUID);

        Bundle extras = new Bundle();
        extras.putParcelable(
                TelecomManager.EXTRA_PHONE_ACCOUNT_HANDLE,
                accountHandle);
        extras.putInt(
            TelecomManager.EXTRA_START_CALL_WITH_VIDEO_STATE,
            hasVideo
                ? VideoProfile.STATE_BIDIRECTIONAL
                : VideoProfile.STATE_AUDIO_ONLY);

        ca.scooter.talkufy.jitsi_sdk.ConnectionService.registerStartCallPromise(callUUID, promise);

        try {
            TelecomManager tm
                = (TelecomManager) ctx.getSystemService(
                        Context.TELECOM_SERVICE);

            tm.placeCall(address, extras);
        } catch (Exception e) {
            ca.scooter.talkufy.jitsi_sdk.ConnectionService.unregisterStartCallPromise(callUUID);
            promise.reject(e);
        }
    }

    /**
     * Called by the JS side of things to mark the call as failed.
     *
     * @param callUUID - the call's UUID.
     */
    @ReactMethod
    public void reportCallFailed(String callUUID) {
        Log.d(TAG, "reportCallFailed " + callUUID);
        ca.scooter.talkufy.jitsi_sdk.ConnectionService.setConnectionDisconnected(
                callUUID,
                new DisconnectCause(DisconnectCause.ERROR));
    }

    /**
     * Called by the JS side of things to mark the call as disconnected.
     *
     * @param callUUID - the call's UUID.
     */
    @ReactMethod
    public void endCall(String callUUID) {
        Log.d(TAG, "endCall " + callUUID);
        ca.scooter.talkufy.jitsi_sdk.ConnectionService.setConnectionDisconnected(
                callUUID,
                new DisconnectCause(DisconnectCause.LOCAL));
    }

    /**
     * Called by the JS side of things to mark the call as active.
     *
     * @param callUUID - the call's UUID.
     */
    @ReactMethod
    public void reportConnectedOutgoingCall(String callUUID) {
        Log.d(TAG, "reportConnectedOutgoingCall " + callUUID);
        ca.scooter.talkufy.jitsi_sdk.ConnectionService.setConnectionActive(callUUID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    /**
     * Called by the JS side to update the call's state.
     *
     * @param callUUID - the call's UUID.
     * @param callState - the map which carries infor about the current call's
     * state. See static fields in {@link ConnectionService.ConnectionImpl}
     * prefixed with "KEY_" for the values supported by the Android
     * implementation.
     */
    @ReactMethod
    public void updateCall(String callUUID, ReadableMap callState) {
        ca.scooter.talkufy.jitsi_sdk.ConnectionService.updateCall(callUUID, callState);
    }
}
