package com.example.application.service;

import com.example.application.dao.AlunoDAO;
import com.example.application.data.entity.Aluno;

public class AlunoService {
    private AlunoDAO alunoDAO;

    public AlunoService() {
        alunoDAO = new AlunoDAO();
    }

    public void registrarAluno(String nome, int turmaId) {
        Aluno aluno = new Aluno(nome, turmaId);
        alunoDAO.save(aluno);
    }

    public Aluno findByName(String nome) {
        return alunoDAO.findByName(nome);
    }
}
