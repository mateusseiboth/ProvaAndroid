package com.seisbot.mateusseiboth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import android.widget.ArrayAdapter;

public class LoggedActivity extends AppCompatActivity {
    ArrayList<String> estilos;
    ArrayList<Banda> arrayList = new ArrayList<>();
    ArrayList<Banda> selecionados = new ArrayList<>();
    ArrayAdapter<Banda> adaptador;
    ListView listagem;
    SearchView busca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        listagem = findViewById(R.id.listView);
        busca = findViewById(R.id.searchView);

        //Criar o evento de busca
        busca.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //forma 1
                //MainActivity3.this.arrayAdapter.getFilter().filter(s);

                //forma 2
                buscarBanda(s);
                adaptador.notifyDataSetChanged();
                return false;
            }
        });



        adaptador = new ArrayAdapter<Banda>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                selecionados
        );
        listagem.setAdapter(adaptador);

        Intent intent = getIntent();
        estilos = (ArrayList<String>) intent.getSerializableExtra("chips");
        arrayList.add(new Banda("Fernando e Fernandinho", "Sertanejo"));
        arrayList.add(new Banda("Vitor e Vitor", "Sertanejo"));
        arrayList.add(new Banda("Lady Gaga", "Pop"));
        arrayList.add(new Banda("Summer Eletro Hits", "Eletrônica"));
        arrayList.add(new Banda("Mc Junior", "Funk"));
        arrayList.add(new Banda("Slayer", "Metal"));
        arrayList.add(new Banda("Junior da Van", "Sertanejo"));

        for (String estilo:estilos
             ) {
            for (Banda disponivel : arrayList) {
                if (estilo.equalsIgnoreCase(disponivel.getEstilo())) {
                    selecionados.add(disponivel);
                }
            }
        }
        adaptador.notifyDataSetChanged();
    }

    //função para buscar as bandas
    private void buscarBanda(String s) {

        selecionados.clear();

        s = s.toLowerCase();

        for(Banda item: arrayList){
            if(item.toString().toLowerCase().contains(s)){
                selecionados.add(item);
            }
        }
        adaptador.notifyDataSetChanged();

    }
}