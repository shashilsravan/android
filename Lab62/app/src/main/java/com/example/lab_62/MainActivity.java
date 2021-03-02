package com.example.lab_62;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReciever = new MyReceiver();
    private static String ACTION_CUSTOM_BROADCAST=
            BuildConfig.APPLICATION_ID+".CUSTOM_MESSAGE_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        this.registerReceiver(myReciever,intentFilter);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(myReciever, new IntentFilter(ACTION_CUSTOM_BROADCAST));

    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(myReciever);
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(myReciever);
        super.onDestroy();
    }

    public void sendCustomBroadcast(View view) {
        Intent cBIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(cBIntent);
    }

}
