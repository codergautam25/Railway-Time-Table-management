package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    EditText nameEditText,emailEditText,phoneEditText,passwordEditText;
    Button registerButton,homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        emailEditText = (EditText)findViewById(R.id.emailEditText);
        phoneEditText = (EditText)findViewById(R.id.phoneEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditTextRegPage);

        registerButton = (Button)findViewById(R.id.registerButton);
        homeButton = (Button)findViewById(R.id.homeButtonRegPage);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationPage.this,MainActivity.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!nameEditText.getText().toString().equals("") && !emailEditText.getText().toString().equals("") && !phoneEditText.getText().toString().equals("") && !passwordEditText.getText().toString().equals("")){
                    DBManager dbManager = new DBManager(view.getContext());
                    String res = dbManager.addRecord(nameEditText.getText().toString(),phoneEditText.getText().toString(),emailEditText.getText().toString(),passwordEditText.getText().toString());

                    Toast.makeText(view.getContext(),res,Toast.LENGTH_LONG).show();

                    if(res.equals("Successfully Inserted")){
                        Intent intent = new Intent(RegistrationPage.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        nameEditText.setText("");
                        emailEditText.setText("");
                        phoneEditText.setText("");
                        passwordEditText.setText("");
                        Toast.makeText(view.getContext(),"Insert again",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(view.getContext(),"Any of the field can't be empty!!",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
