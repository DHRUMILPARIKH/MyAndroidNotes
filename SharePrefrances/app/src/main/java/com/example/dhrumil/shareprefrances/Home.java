package com.example.dhrumil.shareprefrances;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView tv;
    Button logout;

    SharedPreferences pef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv=(TextView)findViewById(R.id.tv_1);
        logout=(Button)findViewById(R.id.logout);

            pef =getSharedPreferences("myshare",MODE_PRIVATE);
            tv.setText("hellow :"+pef.getString("uid",""));

         logout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 SharedPreferences.Editor  edit = pef.edit();
                 edit.putString("uid","");
                 edit.putString("pass","");
                 edit.commit();

                 Intent it = new Intent(Home.this,MainActivity.class);
                 startActivity(it);
                 finish();
             }
         });


    }
}
