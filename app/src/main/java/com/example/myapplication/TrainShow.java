package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class TrainShow extends AppCompatActivity {




    private String[] tNames = {
            "Barrackpore",   //0
            "Naihati",	     //1
            "Shantipur",     //2
            "Krishna Nagar", //3
            "Gede",			 //4
            "Kalyani",		 //5
            "Dankuni",		 //6
            "Lalgola",		 //7
            "Ranaghat"};	 //8



    private final int[][] belghariaToSealdah = {{3,2,7,1,2,1,8,4,5,3,2,0,5,4,8,2,0,3,5,1,8,0,0,3,8,0,2,1,0,1,2,1,8,4,5,3,2,0,5,4,8,2,5,4,8,2,0,3},
            {0*60+9,0*60+29,3*60+58,4*60+43,5*60+12,5*60+28,5*60+38,5*60+56,6*60+5,6*60+20,6*60+40,6*60+58,7*60+4,7*60+12,7*60+24,7*60+39,7*60+55,8*60+1,8*60+15,8*60+32,8*60+40,8*60+41,8*60+54,8*60+58,9*60+4,9*60+8,9*60+13,9*60+13,9*60+21,9*60+47,10*60+10,10*60+20,10*60+37,10*60+51,11*60+12,11*60+32,11*60+47,12*60+1,12*60+24,12*60+39,12*60+53,13*60+15,13*60+49,14*60+30,14*60+58,15*60+24,15*60+49,16*60+15}};

    private final int[][] barrackporeToSealdah = {{5,4,8,3,2,7,1,2,1,8,0,0,3,8,0,2,1,0,1,2,1,8,4,5,3,2,0,2,0,3,5,1,8,4,5,3,2,0,5,4,8,2,5,4,8,2,0,3},
            {0*60+9,0*60+29,3*60+58,4*60+43,5*60+12,5*60+28,5*60+38,5*60+56,6*60+5,6*60+20,6*60+40,6*60+58,7*60+4,7*60+12,7*60+24,7*60+39,7*60+55,8*60+1,8*60+15,8*60+32,8*60+40,8*60+41,8*60+54,8*60+58,9*60+4,9*60+8,9*60+13,9*60+13,9*60+21,9*60+47,10*60+10,10*60+20,10*60+37,10*60+51,11*60+12,11*60+32,11*60+47,12*60+1,12*60+24,12*60+39,12*60+53,13*60+15,13*60+49,14*60+30,14*60+58,15*60+24,15*60+49,16*60+15}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_show);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.myrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent2 = getIntent();
        String s = intent2.getStringExtra(TrainSearch.EXTRA_TEXT);
        String s1 = intent2.getStringExtra(TrainSearch.EXTRA_TEXT1);
        if(s.equals("Belgharia") && s1.equals("Sealdah")) {
            recyclerView.setAdapter(new MyAdapter(belghariaToSealdah, tNames));
        }else if(s.equals("Barrackpore") && s1.equals("Sealdah")){
            recyclerView.setAdapter(new MyAdapter(barrackporeToSealdah, tNames));
        }else {
            Toast.makeText(this,"Train Not available on this route!!",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(TrainShow.this,TrainSearch.class);
            startActivity(intent);
        }

    }
}
