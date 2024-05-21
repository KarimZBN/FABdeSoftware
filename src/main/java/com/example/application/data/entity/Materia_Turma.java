package com.example.application.data.entity;

public class Materia_Turma {
    private int id;
    private int idMateria;
    private int idTurma;
    private int idProfessor;

    public Materia_Turma(int idMateria, int idTurma, int idProfessor) {
        this.idMateria = idMateria;
        this.idTurma = idTurma;
        this.idProfessor = idProfessor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
