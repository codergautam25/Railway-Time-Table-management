package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class railwayGallery extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    RailwayPicAdapter railwayPicAdapter;
    private int[] images = {R.drawable.patna,R.drawable.varanasi,R.drawable.madhubani,R.drawable.chhatrapati_sivaji,R.drawable.chandigarh,R.drawable.darjeeling,R.drawable.delhi,R.drawable.howrah,R.drawable.kolkata,R.drawable.lacknow,R.drawable.ooty,R.drawable.sealdah,R.drawable.goa,R.drawable.chennai};

    private String[] names = {"Patna","Varanashi","Madhubani","Chhatrapati Sivaji","Chandigarh","Darjeeling","Delhi","Howrah","Kolkata","Lacknow","Ooty","Sealdah","Goa","Chennai"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_railway_gallery);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        railwayPicAdapter = new RailwayPicAdapter(names,images);
        recyclerView.setAdapter(railwayPicAdapter);

    }
}
