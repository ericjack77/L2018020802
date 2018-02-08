package com.example.student.l2018020802;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Calendar calendar = Calendar.getInstance();
    private PendingIntent sender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v)
    {
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent it = new Intent(this,MyAlarmService.class);

        //建立PendingIntent
            sender = PendingIntent.getService(this,100,it,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY,3);
            calendar.set(Calendar.MINUTE,45);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);

            am.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),sender);
    }
}
