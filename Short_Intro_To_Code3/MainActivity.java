package com.example.dhrumil.buttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button sb;
    EditText et_un;
    TextView tv,tv1;
    ArrayList<String> ls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = (Button) findViewById(R.id.submit);
        et_un = (EditText) findViewById(R.id.et_un);
        tv = (TextView) findViewById(R.id.tv);tv1 = (TextView)findViewById(R.id.tv2);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char[] arr = et_un.getText().toString().toCharArray();
                CountWord(arr);
                String str = et_un.getText().toString();
                tv1.setText(null);
                duplicate(str);}});
    }
    public int CountWord(char[] string)
    {
        int i = 0;
        boolean notCounted = true;
        int counter = 0;
        while (i < string.length) {
            if (string[i] != ' ') {
                if (notCounted) {
                    notCounted = false;
                    counter++;}}
            else {notCounted = true;}
            i++;}
        tv.setText("No of word in sentance is :"+counter);
        return 0;
    }
    public int CountWord2(String value)
    {
        String item[] = value.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String t : item) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);}
            else {map.put(t, 1);}}
        Set<String> keys = map.keySet();
        String text =" ";
        for (String key : keys) {text = text + key+ " ";}
        tv1.setText(text);
        return 1;
    }
    public void duplicate(String input)
    {
        // first let us split string into words
        String[] words = input.split(" ");
        // adds all words into a map
        // we also check whether the word is already in map!
        Map<String,String> wordMap = new HashMap<String,String>();
        Map<String,String> printedMap = new HashMap<String,String>();
        //String word = words[i].toUpperCase(); // for case insensitive comparison
        for(int i=0;i<words.length;i++) {
            String word = words[i].toUpperCase(); // for case insensitive comparison
            if(wordMap.get(word)!=null) {
                // we found a duplicated word!
                if(printedMap.get(word)==null) { // first check if it is printed already!
                    ls.add(word);
                    printedMap.put(word, word);}}
            else {wordMap.put(word, word);}}
        String count=" "+" ";
        for (String elem : ls){count = count+elem+"\n";}
        ls.clear();
        tv1.setText("Duplicated/Repeated word:"+count);
    }
}



