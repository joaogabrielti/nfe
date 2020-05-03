package dev.joaogabriel.jfiscal.model;

public class Endereco {
    private int id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private int codigo_municipio;
    private String observacoes;

    public Endereco(int id, String rua, String numero, String bairro, String cidade, String estado, String pais, String cep, int codigo_municipio, String observacoes) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.codigo_municipio = codigo_municipio;
        this.observacoes = observacoes;
    }

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String pais, String cep, int codigo_municipio, String observacoes) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.codigo_municipio = codigo_municipio;
        this.observacoes = observacoes;
    }

    public int getCodigo() {
        return id;
    }

    public void setCodigo(int codigo) {
        this.id = codigo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getCodigo_municipio() {
        return codigo_municipio;
    }

    public void setCodigo_municipio(int codigo_municipio) {
        this.codigo_municipio = codigo_municipio;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return this.rua + ", " + this.numero + ", " + this.bairro + ", " + this.cidade + " - " + this.estado;
    }
}