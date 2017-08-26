package com.example.dhrumil.contectlistener;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class logfile extends AppCompatActivity {
    ListView lv;
    List<String> num  = new ArrayList<>();

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logfile);

        lv = (ListView) findViewById(R.id.loglv);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        Cursor cursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);



            while (cursor.moveToNext()) {

                int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
                int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
                int date = cursor.getColumnIndex(CallLog.Calls.DATE);
                int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);

                 num.add(cursor.getString(number) + cursor.getString(type)+cursor.getString(date)+cursor.getString(duration));
               /*  num.add(cursor.getString(type)+"\n");
                 num.add(cursor.getString(date)+"\n");
                 num.add(cursor.getString(duration)+"\n");*/


            }
            cursor.close();

    }
}
