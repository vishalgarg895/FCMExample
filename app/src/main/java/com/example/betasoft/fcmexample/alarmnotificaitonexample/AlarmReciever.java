package com.example.betasoft.fcmexample.alarmnotificaitonexample;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

/**
 * Created by betasoft on 15/8/16.
 */
public class AlarmReciever extends BroadcastReceiver {
    private static String TAG = "AlarmReciever.java";


    @Override
    public void onReceive(Context context, Intent intent) {

        Context appContext=context.getApplicationContext();

        if (intent.getAction().matches("com.example.betasoft.fcmexample.alarmnotificaitonexample.AlarmReciever")) {
            Log.e("Activity Start Alarm", "Notification Alart");

            Intent startIntent = new Intent(context, DealNotificationDialog.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startIntent);

        } else if (intent.getAction().matches("com.example.betasoft.fcmexample.alarmnotificaitonexample.Snooze")) {
            Log.e("Activity Start Alarm", "Notification Alart");
            int notifyID=intent.getIntExtra("notify_id",0);
            /*Canceling 30 Second popup alarm on Snooz click*/
            if(notifyID!=0) {
                Intent popupAlarmIntent = new Intent(context.getApplicationContext(), AlarmReciever.class);
                popupAlarmIntent.setAction("com.example.betasoft.fcmexample.alarmnotificaitonexample.AlarmReciever");
                popupAlarmIntent.putExtra("notify_id", notifyID);
                PendingIntent sender = PendingIntent.getBroadcast(appContext, 0, popupAlarmIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager am = (AlarmManager) appContext.getSystemService(appContext.ALARM_SERVICE);
                am.cancel(sender);
            }
        } else if (intent.getAction().matches("com.example.betasoft.fcmexample.alarmnotificaitonexample.Cancel")) {
            Log.e("Activity Start Alarm", "Notification Alart");
            int notifyID = intent.getIntExtra("notify_id", -1);
            Log.e(TAG, "Notification ID=" + notifyID);
            if (notifyID != -1) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.cancel(notifyID);
            }

        }
    }
}
