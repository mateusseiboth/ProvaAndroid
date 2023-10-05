package com.seisbot.mateusseiboth;

public class AtividadeComplementar {
    String nome;
    String email;
    String documento;
    String horas;
    String categoria;

    public AtividadeComplementar(String nome, String email, String documento, String horas, String categoria) {
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.horas = horas;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "AtividadeComplementar{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", documento='" + documento + '\'' +
                ", horas='" + horas + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}