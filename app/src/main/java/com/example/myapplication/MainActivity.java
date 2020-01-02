package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userIdEditText,passwordEditText;
    Button loginButton,registerButton,skipButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userIdEditText = (EditText)findViewById(R.id.userIdEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditTextRegPage);

        loginButton = (Button)findViewById(R.id.loginButton);
        registerButton = (Button)findViewById(R.id.registerButtonMainPage);
        skipButton = (Button)findViewById(R.id.skipButton);

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        skipButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.loginButton:

                if(validateUser(userIdEditText.getText().toString(),passwordEditText.getText().toString())){
                    Intent intent = new Intent(MainActivity.this,TrainSearch.class);
                    startActivity(intent);
                    Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(this,"You are not a valid user",Toast.LENGTH_SHORT).show();

                }


                break;

            case R.id.registerButtonMainPage:
                Intent intent1 = new Intent(MainActivity.this,RegistrationPage.class);
                startActivity(intent1);
                break;

            case R.id.skipButton:
                Intent intent2 = new Intent(MainActivity.this,TrainSearch.class);
                startActivity(intent2);
                break;

            default:
                Toast.makeText(this,"Something went wrong!!",Toast.LENGTH_LONG).show();
                break;
        }
    }

    public boolean validateUser(String email,String password){

        DBManager dbManager = new DBManager(this);
        Cursor cr = dbManager.getAllData();

        if(email.equals(""))
            return false;
        else if(password.equals(""))
            return false;

        while (cr.moveToNext()){
            if(cr.getString(3).equals(email) && cr.getString(4).equals(password)){
                return true;
            }
        }

        return false;
    }
}
