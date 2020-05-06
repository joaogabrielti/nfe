package dev.joaogabriel.jfiscal.model;

public class CFOP {
    private String cfop;
    private String tipo;
    private String categoria;
    private String descricao;

    public CFOP(String cfop, String tipo, String categoria, String descricao) {
        this.cfop = cfop;
        this.tipo = tipo;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao.toUpperCase();
    }
}
