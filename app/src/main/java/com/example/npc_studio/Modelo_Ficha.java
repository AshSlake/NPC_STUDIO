package com.example.npc_studio;

public class Modelo_Ficha {

    private long id;
    private String nome;
    private String idade;
    private String sexo;

    private String resumo;

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    private String habilidades;
    private String informacoes;

    private String momento_marcante;

    public String getMomento_marcante() {
        return momento_marcante;
    }

    public void setMomento_marcante(String momento_marcante) {
        this.momento_marcante = momento_marcante;
    }

    private String tipo_de_rpg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public String getTipo_de_rpg() {
        return tipo_de_rpg;
    }

    public void setTipo_de_rpg(String tipo_de_rpg) {
        this.tipo_de_rpg = tipo_de_rpg;
    }

    @Override
    public String toString() {
        return getNome();
    }



}
