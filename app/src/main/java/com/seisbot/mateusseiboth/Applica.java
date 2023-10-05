package com.seisbot.mateusseiboth;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class Applica extends Application {

    private List<AtividadeComplementar> atividadesList = new ArrayList<>();

    public List<AtividadeComplementar> getAtividadesList() {
        return atividadesList;
    }

    public void addAtividade(AtividadeComplementar atividade) {
        atividadesList.add(atividade);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Inicialize qualquer configuração ou dados necessários aqui
    }
}