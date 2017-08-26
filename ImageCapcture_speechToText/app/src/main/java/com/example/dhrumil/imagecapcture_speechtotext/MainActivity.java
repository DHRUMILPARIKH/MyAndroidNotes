package com.example.dhrumil.imagecapcture_speechtotext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button image,speech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (Button)findViewById(R.id.imageCapture);
        speech = (Button)findViewById(R.id.SpeechTOText);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,ImageCaptureModule.class);
                startActivity(it);
            }
        });

        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,speechModule.class);
                startActivity(it);
            }
        });

    }
}
