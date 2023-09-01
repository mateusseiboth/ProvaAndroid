package com.seisbot.mateusseiboth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class LoggedActivity extends AppCompatActivity {
    SearchView searchView;
    ListView list;
    ArrayList<String> array = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        searchView = findViewById(R.id.searchView);
        list = findViewById(R.id.listView);

        for(int i =0; i<10; i++){
            array.add("Posição " + i);
        }

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, array);

        list.setAdapter( adapter );

    }
}