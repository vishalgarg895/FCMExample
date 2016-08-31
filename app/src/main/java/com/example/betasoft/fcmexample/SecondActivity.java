package com.example.betasoft.fcmexample;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;

import com.example.betasoft.fcmexample.MainActivity;
import com.example.betasoft.fcmexample.alarmnotificaitonexample.AlarmReciever;
import com.example.betasoft.fcmexample.alarmnotificaitonexample.DealNotificationDialog;
import com.example.betasoft.fcmexample.alarmnotificaitonexample.ShowDetailActivity;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by betasoft on 15/8/16.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onResume() {
        super.onResume();

      //  String uri = "http://maps.google.com/maps?saddr=" + "44.871709,-0.505704" + "&daddr=" + "43.572665,3.871447";
        String uri = "google.navigation:q=" + "30.725466, 76.875666" ;//+ "&daddr=" + "43.572665,3.871447";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);
/*
        Context a = getApplicationContext();
        final long alarmId = (int) System.currentTimeMillis();
        final int notifyID = (int) System.currentTimeMillis();
        Calendar cal = Calendar.getInstance();

        *//*Open dialog after 30 second intent*//*
        Intent intent1 = new Intent(getApplicationContext(), AlarmReciever.class);
       *//* intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);*//*
        intent1.setAction("com.example.betasoft.fcmexample.alarmnotificaitonexample.AlarmReciever");
        // intent1.putExtra("id", alarmId);
        intent1.putExtra("notify_id", notifyID);
        PendingIntent sender = PendingIntent.getBroadcast(a, 0, intent1,
                PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) a.getSystemService(a.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis() + 15 * 1000, sender);


        *//********************//*

        *//************************//*
        Intent snoozeIntent = new Intent(this, AlarmReciever.class);
        snoozeIntent.putExtra("notify_id", notifyID);
        intent1.setAction("com.example.betasoft.fcmexample.alarmnotificaitonexample.Snooze");
        PendingIntent mSnoozePendingIntent = PendingIntent.getActivity(a, 0, snoozeIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        Intent cancelIntent = new Intent(this, AlarmReciever.class);
        cancelIntent.putExtra("notify_id", notifyID);
        intent1.setAction("com.example.betasoft.fcmexample.alarmnotificaitonexample.Cancel");
        PendingIntent mCancelPendingIntent = PendingIntent.getActivity(a, 0, cancelIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intent = new Intent(this, ShowDetailActivity.class);
        // Bundle b1
        intent.putExtra("notify_id", notifyID);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id", alarmId + "");
        PendingIntent pendingIntent = PendingIntent.getActivity(a, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        // notification.defaults = Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE;


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Firebase Push Notification")
                .setContentText("Hello Android")
                .addAction(R.mipmap.ic_launcher, "Snooze", mSnoozePendingIntent) // #0
                .addAction(R.mipmap.ic_launcher, "Cancel", mCancelPendingIntent)  // #1
                .setAutoCancel(true)
                .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sound))
                .setContentIntent(pendingIntent);


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notifyID, notificationBuilder.build());*/


    }
}
