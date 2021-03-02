package com.example.lab_62;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID+".CUSTOM_MESSAGE_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String action = intent.getAction();
        String message;
        if(action != null){
            message="Unwanted Connection";
            switch (action){
                case Intent.ACTION_POWER_CONNECTED:
                    message="Power Connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    message="Power DISCONNECTED";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    message="ACTION_CUSTOM_BROADCAST RECEIVED";
                    break;
            }
            Toast.makeText(context,message,Toast.LENGTH_LONG).show();
        }
    }
}
