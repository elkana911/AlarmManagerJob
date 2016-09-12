package id.co.ppu.alarmmanagerjob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Eric on 12-Sep-16.
 */
public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("eric.alarm", "Job should do something");
        Toast.makeText(context, "I should do something", Toast.LENGTH_SHORT).show();
    }
}
