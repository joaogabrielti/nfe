package dev.joaogabriel.jfiscal.model;

public class Pais {
    private String gentilico;
    private String nome_pais;
    private String nome_pais_int;
    private String sigla;

    public Pais(String gentilico, String nome_pais, String nome_pais_int, String sigla) {
        this.gentilico = gentilico;
        this.nome_pais = nome_pais;
        this.nome_pais_int = nome_pais_int;
        this.sigla = sigla;
    }

    public String getGentilico() {
        return gentilico;
    }

    public void setGentilico(String gentilico) {
        this.gentilico = gentilico;
    }

    public String getNome_pais() {
        return nome_pais;
    }

    public void setNome_pais(String nome_pais) {
        this.nome_pais = nome_pais;
    }

    public String getNome_pais_int() {
        return nome_pais_int;
    }

    public void setNome_pais_int(String nome_pais_int) {
        this.nome_pais_int = nome_pais_int;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return this.nome_pais.toUpperCase();
    }
}