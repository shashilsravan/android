package com.example.lab_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }

        });

        createNotificationChannel();

    }

    public void sendNotification(){
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }

    public void createNotificationChannel(){
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(PRIMARY_CHANNEL_ID,
                            "My Notification",
                            NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from MyAPP");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        Intent notificationIntent =
                new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent =
                PendingIntent.getActivity(this, NOTIFICATION_ID,
                        notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notifyBuilder =
                new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                        .setContentTitle("You've been notified!")
                        .setContentText("This is your notification text.")
                        .setContentIntent(notificationPendingIntent)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setAutoCancel(true);
        return notifyBuilder;
    }
}
