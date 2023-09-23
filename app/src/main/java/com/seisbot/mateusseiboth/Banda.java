package com.seisbot.mateusseiboth;

public class Banda {
    String nome;
    String estilo;

    public Banda(String nome, String estilo) {
        this.nome = nome;
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Estilo: " + estilo + " - Banda: " + nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}