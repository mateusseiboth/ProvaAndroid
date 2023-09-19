package com.seisbot.mateusseiboth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class StylesActivity extends AppCompatActivity {

    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles);
        username = findViewById(R.id.welcomeMessage);


        Bundle b = getIntent().getExtras();
        String value = "";
        if(b != null){
            value = b.getString("mail");

            username.setText(username.getText().toString() + value);
        } else {
            username.setText("Como chegou aqui?");
        }

            Log.d("Nome recebido", value);
    }
}