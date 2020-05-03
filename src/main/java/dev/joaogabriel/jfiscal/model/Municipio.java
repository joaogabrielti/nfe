package dev.joaogabriel.jfiscal.model;

public class Municipio {
    private int uf;
    private String nome_uf;
    private int cod_municipio;
    private String nome_municipio;

    public Municipio(int uf, String nome_uf, int cod_municipio, String nome_municipio) {
        this.uf = uf;
        this.nome_uf = nome_uf;
        this.cod_municipio = cod_municipio;
        this.nome_municipio = nome_municipio;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public String getNome_uf() {
        return nome_uf;
    }

    public void setNome_uf(String nome_uf) {
        this.nome_uf = nome_uf;
    }

    public int getCod_municipio() {
        return cod_municipio;
    }

    public void setCod_municipio(int cod_municipio) {
        this.cod_municipio = cod_municipio;
    }

    public String getNome_municipio() {
        return nome_municipio;
    }

    public void setNome_municipio(String nome_municipio) {
        this.nome_municipio = nome_municipio;
    }

    @Override
    public String toString() {
        return this.nome_municipio.toUpperCase();
    }
}