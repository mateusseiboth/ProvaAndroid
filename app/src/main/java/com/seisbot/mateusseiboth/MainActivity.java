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

    Button entrar;
    EditText email, senha;
    TextView criarUser, esqueceuSenha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.edEmailLogin);
        senha = findViewById(R.id.edSenhaLogin);
        entrar = findViewById(R.id.btEntrar);
        criarUser = findViewById(R.id.tvCriarUser);
        esqueceuSenha = findViewById(R.id.tvEsqueceuSenha);

        entrar.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
            String validaEmail = email.getText().toString();
            String validaSenha = senha.getText().toString();

            try{
                if(validaSenha.trim().equals("") && validaSenha.trim().equals("")) {
                    email.setError("Preencha os dois campos");
                    senha.setError("Preencha os dois campos");
                    throw new Exception("Deu ruim patrão");
                }

                if(validaEmail.trim().equals("")) {
                    email.setError("Preencha o campo email");
                    throw new Exception("Deu ruim patrão");
                } else if(!Patterns.EMAIL_ADDRESS.matcher(validaEmail).matches()) {
                    email.setError("Preencha um email válido");
                    throw new Exception("Deu ruim patrão");
                }
                if(validaSenha.trim().equals("")) {
                    senha.setError("Preencha o campo senha");
                    throw new Exception("Deu ruim patrão");
                }

                Log.e("Valores do form são", ("\n Usuario:" + validaEmail + "\n Senha: " + validaSenha));
                Toast.makeText(getApplicationContext(),"Usuário Logado", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, StylesActivity.class);
                Bundle b = new Bundle();
                b.putString("mail", validaEmail);
                i.putExtras(b);
                startActivity(i);

            } catch (Exception e) {
                Log.d("Exception", e.toString());
                //throw new RuntimeException(e);
            }
    }
}