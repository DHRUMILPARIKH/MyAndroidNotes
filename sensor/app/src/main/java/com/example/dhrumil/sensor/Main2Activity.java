package com.example.dhrumil.sensor;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements SensorEventListener {
    TextView tv ;
    SensorManager man;
    float fx=0 , fy=0 ,fz=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv =(TextView)findViewById(R.id.tv);
        man = (SensorManager)getSystemService(SENSOR_SERVICE);


        Intent in = getIntent();

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {

    float[] ary = event.values;
        float x = ary[1];
        float y = ary[2];
        //float z = ary[2];

        if( x>(fx+10) || x<(fx-10) )
        {
            tv.setBackgroundColor(Color.BLUE);
        }
        else if( y>(fy+10) || y<(fy-10) )
        {
            tv.setBackgroundColor(Color.GRAY);
        }

        /*else if( z>(fz+10) || z<(fz-10) )
        {
            tv.setBackgroundColor(Color.GREEN);
        }*/

        fx=x;
        fy=y;
        //fz=z;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        man.registerListener(this,man.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        man.unregisterListener(this);
    }
}
