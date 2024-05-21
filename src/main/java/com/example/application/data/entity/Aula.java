package com.example.application.data.entity;

public class Aula {
    private int id;
    private String conteudo;
    private int numeroAula;
    private int idMateriaTurma;

    public Aula(int id, String conteudo, int numeroAula, int idMateriaTurma) {
        this.id = id;
        this.conteudo = conteudo;
        this.numeroAula = numeroAula;
        this.idMateriaTurma = idMateriaTurma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public int getIdMateriaTurma() {
        return idMateriaTurma;
    }

    public void setIdMateriaTurma(int idMateriaTurma) {
        this.idMateriaTurma = idMateriaTurma;
    }
}
