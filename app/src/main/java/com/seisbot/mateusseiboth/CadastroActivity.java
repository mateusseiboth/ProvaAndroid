package com.seisbot.mateusseiboth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class CadastroActivity extends AppCompatActivity  implements View.OnClickListener {
    EditText edNome, edMail, edDocumento, dHoras;
    Button btnSave;
    Spinner cat;
    String select;

    ArrayList<AtividadeComplementar> arrayAtv = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edNome = findViewById(R.id.edNome);
        edMail = findViewById(R.id.edMail);
        edDocumento = findViewById(R.id.edDescr);
        dHoras = findViewById(R.id.edCarga);
        btnSave = findViewById(R.id.btnSalvar);
        cat = findViewById(R.id.categoria);


        Spinner spinner = (Spinner) findViewById(R.id.categoria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnSave.setOnClickListener(this);

        cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select = cat.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    @Override
    public void onClick(View view) {
        Applica applica = (Applica) getApplication();
        if(edNome.getText().toString().equals("")) {
            edNome.setError("Campo vazio");
            return;
        }
        if(edMail.getText().toString().equals("")) {
            edMail.setError("Campo vazio");
            return;
        }
        if(edDocumento.getText().toString().equals("")) {
            edDocumento.setError("Campo vazio");
            return;
        }
        if(dHoras.getText().toString().equals("")) {
            dHoras.setError("Campo vazio");
            return;
        }
        AtividadeComplementar atividade = new AtividadeComplementar(edNome.getText().toString(), edMail.getText().toString(), edDocumento.getText().toString(), dHoras.getText().toString(), select);
        applica.addAtividade(atividade);
        mostrar();
    }



    public void mostrar(){
        Applica conext1 = (Applica) getApplication();
        List<AtividadeComplementar> atividades = conext1.getAtividadesList();
        for(AtividadeComplementar item : atividades) {
            Log.e("Item", item.toString());

        }
    }

}
