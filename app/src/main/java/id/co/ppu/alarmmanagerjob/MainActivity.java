package id.co.ppu.alarmmanagerjob;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentAlarm = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);

        Button btnSetJob = (Button) findViewById(R.id.btnSetJob);
        btnSetJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                // start 10 seconds from now
                cal.add(Calendar.SECOND, 10);

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                // repeat every 10 seconds
                alarmManager.setRepeating(AlarmManager.RTC, cal.getTimeInMillis(), 10000, pendingIntent);

                Toast.makeText(MainActivity.this, "Job scheduled !", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnCancelJob = (Button) findViewById(R.id.btnCancelJob);
        btnCancelJob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                manager.cancel(pendingIntent);
                Toast.makeText(MainActivity.this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
