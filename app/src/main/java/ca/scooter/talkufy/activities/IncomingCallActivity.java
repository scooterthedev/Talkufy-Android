package ca.scooter.talkufy.activities;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import ca.scooter.talkufy.utils.utils;

import org.jitsi.meet.sdk.JitsiMeetActivity;

import java.util.Objects;

import ca.scooter.talkufy.R;
import ca.scooter.talkufy.jitsi_sdk.JitsiMeetConferenceOptions;
import ca.scooter.talkufy.utils.FirebaseUtils;
import de.hdodenhof.circleimageview.CircleImageView;

public class IncomingCallActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_incoming_call);

        if (getIntent()==null)
            finish();

        Objects.requireNonNull(getSupportActionBar()).hide();
        // init constraintLayout
        LinearLayout layout = findViewById(R.id.linearLayout);
        // initializing animation drawable by getting background from constraint layout
        animationDrawable = (AnimationDrawable) layout.getBackground();
        // setting enter fade animation duration to 5 seconds
        animationDrawable.setEnterFadeDuration(5000);
        // setting exit fade animation duration to 2 seconds
        animationDrawable.setExitFadeDuration(2000);





        String call_id = getIntent().getStringExtra("call_id");
        String caller_name = getIntent().getStringExtra("caller_name");
        String caller_phone = getIntent().getStringExtra("caller_phone");
        String caller_uid = getIntent().getStringExtra("caller_uid");
        boolean audioOnly = getIntent().getBooleanExtra("audioOnly",true);

        ImageView buttonPick  = findViewById(R.id.buttonPick);
        ImageView buttonReject  = findViewById(R.id.buttonReject);
        ImageButton buttonReplyWithMessage  = findViewById(R.id.buttonReplyWithMessage);
        ImageView call_type_image = findViewById(R.id.call_type_image);
        TextView call_type_text = findViewById(R.id.call_type_text);

        CircleImageView caller_imageview = findViewById(R.id.caller_imageview);

        FirebaseUtils.INSTANCE.loadProfilePic(this,caller_uid,caller_imageview);
        TextView callerName = findViewById(R.id.callername);
        TextView callerNumber = findViewById(R.id.callernumber);
        callerName.setText(caller_name);
        callerNumber.setText(caller_phone);

        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                .setRoom(call_id)
                .setAudioOnly(audioOnly)
                .build();


        if (!audioOnly){
            call_type_text.setText("Video Call");
            call_type_image.setImageResource(R.drawable.vw_ic_video_camera);
        }

        buttonPick.setOnClickListener(v -> {
            replyToNewCall(utils.constants.CALL_STATUS_ANSWERED,caller_uid);
                buttonPick.setEnabled(false);
               JitsiMeetActivity.launch(getApplicationContext(), String.valueOf(options));
            });

        buttonReject.setOnClickListener(v -> {
            replyToNewCall(utils.constants.CALL_STATUS_REJECTED,caller_uid);
            finish();
        });

        buttonReplyWithMessage.setOnClickListener(v->{
            replyToNewCall(utils.constants.CALL_STATUS_REJECTED,caller_uid);
            showReplayMessage(caller_uid);
            finish();
        });

        FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid()).child("call_status")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            String call_status = Objects.requireNonNull(dataSnapshot.getValue()).toString();
                            if (utils.constants.CALL_STATUS_CALL_ENDED.equals(call_status)) {
                                replyToNewCall(utils.constants.CALL_STATUS_CALL_ENDED, caller_uid);
                                finish();
                            }
                        }else{
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }

    private void showReplayMessage(String caller_uid) {
        Toast.makeText(this, "Replay message to "+caller_uid, Toast.LENGTH_SHORT).show();
    }


    private void replyToNewCall(String callStatus, String caller_uid) {
        FirebaseUtils.ref.INSTANCE.callRef(caller_uid).child("call_status")
                .setValue(callStatus);

        FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid()).child("call_status")
                .setValue(callStatus);

    }



    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            // start the animation
            animationDrawable.start();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            // stop the animation
            animationDrawable.stop();
        }
    }

}
