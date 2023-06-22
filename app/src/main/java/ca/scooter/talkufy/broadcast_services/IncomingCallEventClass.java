package ca.scooter.talkufy.broadcast_services;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import ca.scooter.talkufy.utils.FirebaseUtils;
import ca.scooter.talkufy.utils.utils;

import java.util.Objects;

import ca.scooter.talkufy.activities.IncomingCallActivity;

public class IncomingCallEventClass {
    private final Context context;
    private final String myUid = FirebaseUtils.INSTANCE.getUid();

    Uri uri;
    Ringtone ringtone;
    Vibrator vibrator;


    public IncomingCallEventClass(Context context) {
        this.context = context;
        uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        ringtone = RingtoneManager.getRingtone(context, uri);
        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void initiatializeEvent() {
        FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists() && dataSnapshot.hasChildren()) {

                            if (dataSnapshot.hasChild("call_initiator")) {

                                if (!Objects.requireNonNull(dataSnapshot.child("call_initiator").getValue()).toString()
                                        .equals(myUid)) {

                                        checkCallInitiatedTime(dataSnapshot);

                                } else {
                                   checkIfItsRealCall(dataSnapshot);
                                }
                            } else {
                                    stopRingingTone();


                            }
                        } else {
                                stopRingingTone();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    private void checkCallInitiatedTime(DataSnapshot callSnapshot) {
        if (callSnapshot.hasChild("call_initiated_time") &&
                !TextUtils.isEmpty(Objects.requireNonNull(callSnapshot.child("call_initiated_time").getValue()).toString())){
            long initiatedTime = Long.parseLong(Objects.requireNonNull(callSnapshot.child("call_initiated_time").getValue()).toString());
            long currentTime = System.currentTimeMillis();
            if (currentTime>(initiatedTime+600000)){
                FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid())
                        .removeValue();

                    stopRingingTone();

            }else{

                if (Objects.requireNonNull(callSnapshot.child("call_status").getValue()).toString()
                        .equals( utils.constants.CALL_STATUS_CALLING)) {

                    switch (ca.scooter.talkufy.broadcast_services.PhoneStateBroadcastReciever.phoneState) {
                        case utils.constants.PHONE_STATE_INCOMING_CALL:
                            replyToNewCall(utils.constants.CALL_STATUS_BUSY, callSnapshot);

                            break;
                        case utils.constants.PHONE_STATE_ONGOING_CALL:
                            replyToNewCall(utils.constants.CALL_STATUS_ANOTHER_CALL, callSnapshot);

                            break;
                        case utils.constants.PHONE_STATE_IDLE:
                            getCallerInfo(callSnapshot);
                            break;
                    }

                }else {
                    if (!Objects.requireNonNull(callSnapshot.child("call_status").getValue()).toString()
                            .equals( utils.constants.CALL_STATUS_RINGING))
                    stopRingingTone();
                }


            }

        } else{
            FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid())
                    .removeValue();
        }
    }

    private void getCallerInfo(DataSnapshot callSnapshot) {
        String callerId = Objects.requireNonNull(callSnapshot.child("call_initiator").getValue()).toString();
        FirebaseUtils.ref.INSTANCE.user(callerId)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists() && dataSnapshot.hasChildren()){
                            String phone = Objects.requireNonNull(dataSnapshot.child("phone").getValue()).toString();

                            openIncomingCallIntent(callSnapshot, phone);

                        }else{
                            FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid())
                                    .removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    private void openIncomingCallIntent(DataSnapshot callSnapshot, String phone) {
        Intent intent = new Intent(context, IncomingCallActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("call_id", Objects.requireNonNull(callSnapshot.child("call_id").getValue()).toString());
        intent.putExtra("caller_name", utils.INSTANCE.getNameFromNumber(context,phone));
        intent.putExtra("caller_phone",phone);
        intent.putExtra("caller_uid", Objects.requireNonNull(callSnapshot.child("call_initiator").getValue()).toString());
        intent.putExtra("audioOnly", Objects.equals(callSnapshot.child("audioOnly").getValue(), true));
        context.startActivity(intent);
        replyToNewCall(utils.constants.CALL_STATUS_RINGING, callSnapshot);
        playRingingTone();
    }

    private void checkIfItsRealCall(DataSnapshot dataSnapshot) {
        if(dataSnapshot.hasChild("call_involvers") &&
                !Objects.requireNonNull(dataSnapshot.child("call_involvers").getValue()).toString()
                        .equals(FirebaseUtils.INSTANCE.getUid())){

            Log.d("IncomingCallEventClass", "checkIfItsRealCall: "+FirebaseUtils.INSTANCE.getUid()+" is initiating a call");
        }else {
            FirebaseUtils.ref.INSTANCE.callRef(FirebaseUtils.INSTANCE.getUid())
                    .removeValue();
                stopRingingTone();

        }
    }


    private void replyToNewCall(String callStatus, DataSnapshot callSnapshot) {
        FirebaseUtils.ref.INSTANCE.callRef(Objects.requireNonNull(
                callSnapshot.child("call_initiator").getValue()).toString()).child("call_status")
                .setValue(callStatus);

        FirebaseUtils.ref.INSTANCE.callRef(Objects.requireNonNull(
                callSnapshot.child("call_involvers").getValue()).toString()).child("call_status")
                .setValue(callStatus);

    }


    private void playRingingTone() {
        ringtone.play();
        vibrator.vibrate(30000);

    }

    private void stopRingingTone() {
        if (ringtone.isPlaying())
            ringtone.stop();
        vibrator.cancel();
    }
}
