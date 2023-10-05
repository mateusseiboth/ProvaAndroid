package com.seisbot.mateusseiboth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ListaActivity extends AppCompatActivity {

    ListView listagem;
    Button btnVolta;
    ArrayAdapter<AtividadeComplementar> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        btnVolta = findViewById(R.id.btnVoltar);
        listagem = findViewById(R.id.list);

        Applica applica = (Applica) getApplication();
        List<AtividadeComplementar> atividades = applica.getAtividadesList();

        for(AtividadeComplementar atv : atividades){
            Log.e("Aqui", atv.toString());
        }

        btnVolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if(!atividades.isEmpty()){
            arrayAdapter = new ArrayAdapter<AtividadeComplementar>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    atividades
            );
            listagem.setAdapter(arrayAdapter);

        }

    }
}