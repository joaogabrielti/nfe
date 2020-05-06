package dev.joaogabriel.jfiscal.model;

public class Empresa {
    private int id;
    private String cnpj_cpf;
    private String fantasia;
    private String razao_social;
    private String inscricao_estadual;
    private boolean tipo; // false = Pessoa Física, true = Pessoa Jurídica
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String codigo_municipio;
    private String observacoes;

    public Empresa(int id, String cnpj_cpf, String fantasia, String razao_social, String inscricao_estadual, boolean tipo, String rua, String numero, String bairro, String cidade, String estado, String pais, String cep, String codigo_municipio, String observacoes) {
        this.id = id;
        this.cnpj_cpf = cnpj_cpf;
        this.fantasia = fantasia;
        this.razao_social = razao_social;
        this.inscricao_estadual = inscricao_estadual;
        this.tipo = tipo;
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

    public Empresa(String cnpj_cpf, String fantasia, String razao_social, String inscricao_estadual, boolean tipo, String rua, String numero, String bairro, String cidade, String estado, String pais, String cep, String codigo_municipio, String observacoes) {
        this.cnpj_cpf = cnpj_cpf;
        this.fantasia = fantasia;
        this.razao_social = razao_social;
        this.inscricao_estadual = inscricao_estadual;
        this.tipo = tipo;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj_cpf() {
        return cnpj_cpf;
    }

    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
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

    public String getCodigo_municipio() {
        return codigo_municipio;
    }

    public void setCodigo_municipio(String codigo_municipio) {
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
        return this.cnpj_cpf + " - " + this.fantasia;
    }
}
