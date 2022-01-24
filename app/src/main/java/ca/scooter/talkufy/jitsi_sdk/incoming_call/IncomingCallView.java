package ca.scooter.talkufy.jitsi_sdk.incoming_call;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReadableMap;

import java.lang.reflect.Method;
import java.util.Map;

import ca.scooter.talkufy.jitsi_sdk.BaseReactView;
import ca.scooter.talkufy.jitsi_sdk.ListenerUtils;

public class IncomingCallView
    extends BaseReactView<IncomingCallViewListener> {

    /**
     * The {@code Method}s of {@code JitsiMeetViewListener} by event name i.e.
     * redux action types.
     */
    private static final Map<String, Method> LISTENER_METHODS
        = ListenerUtils.mapListenerMethods(ca.scooter.talkufy.jitsi_sdk.incoming_call.IncomingCallViewListener.class);

    public IncomingCallView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onExternalAPIEvent(String name, ReadableMap data) {
        onExternalAPIEvent(LISTENER_METHODS, name, data);
    }

    /**
     * Sets the information for the incoming call this {@code IncomingCallView}
     * represents.
     *
     * @param callInfo - {@link IncomingCallInfo} object representing the caller
     * information.
     */
    public void setIncomingCallInfo(IncomingCallInfo callInfo) {
        Bundle props = new Bundle();

        props.putString("callerAvatarURL", callInfo.getCallerAvatarURL());
        props.putString("callerName", callInfo.getCallerName());
        props.putBoolean("hasVideo", callInfo.hasVideo());

        createReactRootView("IncomingCallApp", props);
    }
}
