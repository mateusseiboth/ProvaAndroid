package com.seisbot.mateusseiboth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class StylesActivity extends AppCompatActivity implements View.OnClickListener {

    TextView username;
    Button btnNextPage;
    ChipGroup chips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles);
        username = findViewById(R.id.welcomeMessage);
        btnNextPage = findViewById(R.id.btnNext);
        chips = findViewById(R.id.chipGroup);
        Bundle b = getIntent().getExtras();
        String value = "";
        if(b != null){
            value = b.getString("mail");

            username.setText(username.getText().toString() + value);
        } else {
            username.setText("Como chegou aqui?");
        }


            Log.d("Nome recebido", value);
        btnNextPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        List<Integer> ids = chips.getCheckedChipIds();
        ArrayList<String> arrayList = new ArrayList<>();

        for (Integer id:ids){
            Log.e("id:", ""+id);
            Chip chip = chips.findViewById(id);
            String estilo = chip.getText().toString();
            arrayList.add(estilo);
        }
        Intent i = new Intent(StylesActivity.this, LoggedActivity.class);
        i.putExtra("chips", arrayList);
        startActivity(i);
    }
}