package com.example.betasoft.fcmexample.alarmnotificaitonexample;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.betasoft.fcmexample.R;

/**
 * Created by betasoft on 15/8/16.
 */
public class ShowDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String alarmId = getIntent().getStringExtra("id");
        Context a = getApplicationContext();
        Intent intent1 = new Intent();
        intent1.setAction("com.example.betasoft.fcmexample.alarmnotificaitonexample.AlarmReciever");
        intent1.putExtra("id", alarmId);

        PendingIntent sender = PendingIntent.getBroadcast(a, 0, intent1,
                PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) a.getSystemService(a.ALARM_SERVICE);
        am.cancel(sender);
    }
}
