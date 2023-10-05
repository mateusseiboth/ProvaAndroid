package com.seisbot.mateusseiboth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCad, btnList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCad = findViewById(R.id.btnCadastro);
        btnCad.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
            Log.e("Passei", "Passei aqui");
            try{
                   Intent i = new Intent(MainActivity.this, CadastroActivity.class);
                   startActivity(i);

            } catch (Exception e) {
                Log.d("Exception", e.toString());
                //throw new RuntimeException(e);
            }
    }
}