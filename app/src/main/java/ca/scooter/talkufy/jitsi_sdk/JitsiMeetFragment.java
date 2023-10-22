package ca.scooter.talkufy.jitsi_sdk;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.modules.core.PermissionListener;

import java.util.Map;

/**
 * Base {@link Fragment} for applications integrating Jitsi Meet at a higher level. It
 * contains all the required wiring between the {@code JitsiMeetView} and
 * the Fragment lifecycle methods already implemented.
 *
 * In this fragment we use a single {@code JitsiMeetView} instance. This
 * instance gives us access to a view which displays the welcome page and the
 * conference itself. All lifecycle methods associated with this Fragment are
 * hooked to the React Native subsystem via proxy calls through the
 * {@code JitsiMeetActivityDelegate} static methods.
 */
public class JitsiMeetFragment extends Fragment implements JitsiMeetViewListener {


    // Instance of the {@link JitsiMeetView} which this activity will display.

    private JitsiMeetView view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return this.view = new JitsiMeetView(requireActivity());
    }

    public JitsiMeetView getJitsiView() {
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        JitsiMeetActivityDelegate.onHostDestroy(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();

        JitsiMeetActivityDelegate.onHostResume(getActivity());
    }

    @Override
    public void onStop() {
        super.onStop();

        JitsiMeetActivityDelegate.onHostPause(getActivity());
    }

    @Override
    public void onConferenceJoined(Map<String, Object> data) {

    }

    @Override
    public void onConferenceTerminated(Map<String, Object> data) {

    }

    @Override
    public void onConferenceWillJoin(Map<String, Object> data) {

    }

    @Override
    public int checkPermission(String s, int i, int i1) {
        return 0;
    }

    @Override
    public int checkSelfPermission(String s) {
        return 0;
    }

    @Override
    public void requestPermissions(String[] strings, int i, PermissionListener permissionListener) {

    }
}