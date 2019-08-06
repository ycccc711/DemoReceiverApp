package sg.edu.rp.c346.receiverapp;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //2. To register the receiver
    BroadcastReceiver br = new BatteryReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To register the receiver
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        //show the battery low 
        filter.addAction("android.intent.action.BATTERY_LOW");
        this.registerReceiver(br,filter);
    }
    //To unregister the receiver
    @Override
    protected void onDestroy() {

        super.onDestroy();
        this.unregisterReceiver(br);
    }

}
