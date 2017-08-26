package com.example.dhrumil.broadcasrreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    ToggleButton tb;
    BroadcastReceiver br;
    IntentFilter iff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tb = (ToggleButton)findViewById(R.id.tb);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    getApplicationContext().registerReceiver(br,iff);
                }
                else{
                    getApplicationContext().unregisterReceiver(br);
                }


            }
        });

        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                int current = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
                int total = intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);

                tv1.setText("Battry : "+current+" % from "+total+"%");

                int status =  intent.getIntExtra("status",BatteryManager.BATTERY_STATUS_CHARGING);
                if (status==3)
                {
                    tv2.setText("not charging");
                    tv2.setBackgroundColor(Color.RED);
                }
                else
                {
                    tv2.setText("charging");
                    tv2.setBackgroundColor(Color.GREEN);
                }

            }
        };

        iff = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

    }
}
