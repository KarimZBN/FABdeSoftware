package com.example.application.data.entity;

public class Presenca {
    private int alunoId;
    private int aulaId;
    private boolean presente;

    public Presenca(int alunoId, int aulaId, boolean presente) {
        this.alunoId = alunoId;
        this.aulaId = aulaId;
        this.presente = presente;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getAulaId() {
        return aulaId;
    }

    public void setAulaId(int aulaId) {
        this.aulaId = aulaId;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
