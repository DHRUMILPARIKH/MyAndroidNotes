package com.example.dhrumil.mycotectlist;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    ListView lv;
    List<String> datas= new ArrayList<>();
    List<String> contact= new ArrayList<>();
    //List<Character> number = new ArrayList<>();
    String[] data,call,cname,cnumber,data1,call1,lnumber,lname = new String[0];
    int number;
    int type,date,duration;
    Cursor managedCursor , phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv1);

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

        phone = mContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
         data = new String[phone.getCount()];

        call = new String[phone.getCount()];
        cname = new String[phone.getCount()];
        cnumber= new String[phone.getCount()];

        managedCursor = managedQuery(CallLog.Calls.CONTENT_URI,null,null,null,null);
        data1 = new  String[managedCursor.getCount()];
        call1 = new  String[managedCursor.getCount()];
        lnumber = new String[managedCursor.getCount()];
        lname = new String[managedCursor.getCount()];

        number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);

        /*while (phone.moveToNext()) {
            String name = phone.getString(phone.getColumnIndex(CallLog.Calls.DATE));
            String num = phone.getString(phone.getColumnIndex(CallLog.Calls.DURATION));
            //home work - call log
            data.add(num);
            //names.add(name);
            contact.add(name + " " + num);
        }
        phone.close();
*/
        contact.add(phone.getString(number));
        phone.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, contact);
        lv.setAdapter(adapter);

    }
}
