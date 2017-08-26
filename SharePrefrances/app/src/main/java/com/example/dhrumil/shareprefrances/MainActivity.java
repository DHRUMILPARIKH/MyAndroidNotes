package com.example.dhrumil.shareprefrances;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button sub;
    EditText us_id,pass;
    SharedPreferences pif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sub = (Button)findViewById(R.id.bt_submit);
        us_id = (EditText)findViewById(R.id.us_id);
        pass=(EditText)findViewById(R.id.et_pass) ;

        pif = getSharedPreferences("myshare",MODE_PRIVATE);
        String uid = pif.getString(us_id.getText().toString(),"");

        if(!uid.equals(""))
        {
            Intent it = new Intent(MainActivity.this,Home.class);
            startActivity(it);
            finish();
        }


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SharedPreferences.Editor  edit = pif.edit();
                edit.putString("uid",us_id.getText().toString());
                edit.putString("pass",pass.getText().toString());
                edit.commit();

                Intent it = new Intent(MainActivity.this,Home.class);
                startActivity(it);
                finish();
            }
        });




    }
}
