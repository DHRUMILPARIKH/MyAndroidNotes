package com.example.dhrumil.imagecapcture_speechtotext;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class speechModule extends AppCompatActivity {

    String da="";
    List<String> li =new ArrayList<>();
    TextView tv;
    Intent ii;
    List<String> allcontect = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_module);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lv = (ListView)findViewById(R.id.lisstview);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ii=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                ii.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(ii,121);
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==121&&resultCode==RESULT_OK)
        {
            ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            // da=result.get(0);
            for(int i=0;i<result.size();i++)
            {
                da=da+result.get(i)+"\n";
                allcontect.add(i +" :"+result.get(i));
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(speechModule.this, android.R.layout.simple_expandable_list_item_1, allcontect);
            lv.setAdapter(adapter);

            tv = (TextView) findViewById(R.id.tv_speech);
            tv.setText(da);


        }


    }


}

