package com.example.dhrumil.contectlistener;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    List<String> allcontect = new ArrayList<>();

    ArrayList<String> number = new ArrayList<>();
      /*ArrayList<String> names = new ArrayList<>();*/
    //ArrayList is generic class
    //refrance give to List and object is defind of ArrayList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3 Parameters --current context,which type of object,source
        //courser which is same as resultset in java in database (resultset.next()....),store data in 2d array

        Cursor phone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        /*Cursor cursor = mContext.getContentResolver().query(Calls.CONTENT_URI, projection, 
                                Calls.TYPE + "=" + Calls.OUTGOING_TYPE, null, Calls.DEFAULT_SORT_ORDER + 
                        " LIMIT 1"); */
       while (phone.moveToNext()) {
            String name = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            //home work - call log
            number.add(num);
            //names.add(name);
            allcontect.add(name + " " + num);
        }
        phone.close();


        //mapping
        lv = (ListView) findViewById(R.id.list1);
        //ListView --> ArrayAdepter(Adgust Data) --> ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, allcontect);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

             /*
              Intent it = new Intent(MainActivity.this,Activity2.class);
                it.putExtra("num",number.get(position));
                it.putExtra("namee",names.get(position));
                */

               Toast.makeText(MainActivity.this, "click : " + number.get(position), Toast.LENGTH_SHORT).show();
                String mynum = "tel:" + number.get(position);
                Intent ii = new Intent(Intent.ACTION_CALL, Uri.parse(mynum));

                //above is warning that u have not take permition from user ....



                startActivity(ii);
            }
        });

        //home resarch - set image in contact , hint bitmap object
        //get call-log
    }
}
