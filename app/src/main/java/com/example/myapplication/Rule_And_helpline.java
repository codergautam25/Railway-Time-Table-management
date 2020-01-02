package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Rule_And_helpline extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String []ruless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule__and_helpline);

        listView=findViewById(R.id.Lists);
        textView=findViewById(R.id.Rules_And_Helplines);
        ruless=getResources().getStringArray(R.array.array_technology);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, ruless);
        listView.setAdapter(adapter);


    }
}
