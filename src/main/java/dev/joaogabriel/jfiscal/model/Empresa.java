package dev.joaogabriel.jfiscal.model;

public class Empresa {
    private int id;
    private String cnpj_cpf;
    private String fantasia;
    private String razao_social;
    private String inscricao_estadual;
    private boolean tipo; // false = Pessoa Física, true = Pessoa Jurídica
    private Endereco endereco;
    private String site;
    private String contato;
    private String observacoes;

    public Empresa(int id, String cnpj_cpf, String fantasia, String razao_social, String inscricao_estadual, boolean tipo, Endereco endereco, String site, String contato, String observacoes) {
        this.id = id;
        this.cnpj_cpf = cnpj_cpf;
        this.fantasia = fantasia;
        this.razao_social = razao_social;
        this.inscricao_estadual = inscricao_estadual;
        this.tipo = tipo;
        this.endereco = endereco;
        this.site = site;
        this.contato = contato;
        this.observacoes = observacoes;
    }

    public Empresa(String cnpj_cpf, String fantasia, String razao_social, String inscricao_estadual, boolean tipo, Endereco endereco, String site, String contato, String observacoes) {
        this.cnpj_cpf = cnpj_cpf;
        this.fantasia = fantasia;
        this.razao_social = razao_social;
        this.inscricao_estadual = inscricao_estadual;
        this.tipo = tipo;
        this.endereco = endereco;
        this.site = site;
        this.contato = contato;
        this.observacoes = observacoes;
    }

    public int getCodigo() {
        return id;
    }

    public void setCodigo(int codigo) {
        this.id = codigo;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return this.fantasia;
    }
}
