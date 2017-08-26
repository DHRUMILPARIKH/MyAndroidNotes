package com.example.dhrumil.contectlistener;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    Intent in ,ii ,ij ;
    TextView tv;
    Button bt;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv = (TextView)findViewById(R.id.tv_name);
        bt = (Button)findViewById(R.id.bt_call);
        iv = (ImageView)findViewById(R.id.contactimg);

        in = getIntent();
       final String name = in.getStringExtra("namee");
        final String num =in.getStringExtra("num");
        tv.setText(name);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity2.this, "click : " +name, Toast.LENGTH_SHORT).show();
                String mynum = "tel:"+num;
                ii = new Intent(Intent.ACTION_CALL, Uri.parse(mynum));
                startActivity(ii);
            }
        });

    }
}
