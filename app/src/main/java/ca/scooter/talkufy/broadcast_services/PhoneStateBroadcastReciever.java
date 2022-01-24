package ca.scooter.talkufy.broadcast_services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import ca.scooter.talkufy.utils.utils;

public class PhoneStateBroadcastReciever extends BroadcastReceiver {

    public static String phoneState  = utils.constants.PHONE_STATE_IDLE;

    @Override
    public void onReceive(Context context, Intent intent) {

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(new CustomPhoneListener(context), PhoneStateListener.LISTEN_CALL_STATE);

    }

    private static class CustomPhoneListener extends PhoneStateListener {
        private Context context;


        CustomPhoneListener(Context context) {
            super();
            this.context = context;
        }

        public CustomPhoneListener() {
        }

        @Override
        public void onCallStateChanged(int state, String phoneNumber) {
            super.onCallStateChanged(state, phoneNumber);

            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE:
                    phoneState = utils.constants.PHONE_STATE_IDLE;
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    phoneState = utils.constants.PHONE_STATE_ONGOING_CALL;
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    phoneState = utils.constants.PHONE_STATE_INCOMING_CALL;
                    break;
                default:
                    break;
            }
        }

    }


}
