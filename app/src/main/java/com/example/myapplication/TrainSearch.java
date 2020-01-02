package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class TrainSearch extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_TEXT = "com.example.myapplication.EXTRA_TEXT";
    public static final String EXTRA_TEXT1 = "com.example.myapplication.EXTRA_TEXT1";

    AutoCompleteTextView source;
    AutoCompleteTextView destination;

    Button swapButton;
    Button searchButton;
    Button homeButton;
    Button locationButton;
    Button helplineButton;
    Button tourButton;

    private final static String []LOCAL_STATION_NAME = {"Howrah","Kolkata","Krisnanager","Lalgola","Naihati","Belgharia","Sealdah","Birati","Ranaghat","Gede","Kalyani","Barrackpore","Barddhaman","Bidhan Nagar","Agarpara","Sodpur","Shantipur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_search);

        source = (AutoCompleteTextView)findViewById(R.id.sourceAutoCompleteTextView);
        destination = (AutoCompleteTextView)findViewById(R.id.destinationAutoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,LOCAL_STATION_NAME);

        source.setAdapter(adapter);
        destination.setAdapter(adapter);

        swapButton = (Button)findViewById(R.id.swapButton);
        searchButton = (Button)findViewById(R.id.searchTrainButton);
        homeButton = (Button)findViewById(R.id.homeButtonTrainSearch);
        locationButton = (Button)findViewById(R.id.locationSearchButton);
        helplineButton = (Button)findViewById(R.id.helpButton);
        tourButton = (Button)findViewById(R.id.railwayTourButton);

        swapButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        locationButton.setOnClickListener(this);
        helplineButton.setOnClickListener(this);
        tourButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.swapButton:
                String temp = source.getText().toString();
                source.setText(destination.getText().toString());
                destination.setText(temp);
                break;

            case R.id.searchTrainButton:
                if(!source.getText().toString().equals("") && !destination.getText().toString().equals("")) {

                    Intent intent = new Intent(TrainSearch.this, TrainShow.class);
                    intent.putExtra(EXTRA_TEXT,source.getText().toString());
                    intent.putExtra(EXTRA_TEXT1,destination.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this,"Please Enetr Source and Destination",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.homeButtonTrainSearch:
                Intent intent1 = new Intent(TrainSearch.this,MainActivity.class);
                startActivity(intent1);
                break;

            case R.id.helpButton:

                Intent i = new Intent(TrainSearch.this,Rule_And_helpline.class);
                startActivity(i);
                break;

            case R.id.locationSearchButton:
                Intent intent2 = new Intent(TrainSearch.this,LocationActivity.class);
                startActivity(intent2);
                break;

            case R.id.railwayTourButton:
                Intent intent3 = new Intent(TrainSearch.this,railwayGallery.class);
                startActivity(intent3);

                break;

            default:
                Toast.makeText(view.getContext(),"Something Went Wrong!!",Toast.LENGTH_LONG).show();
                break;

        }
    }
}
