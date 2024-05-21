package com.example.application.service;

import com.example.application.dao.TurmaDAO;
import com.example.application.data.entity.Turma;

public class TurmaService {

    private TurmaDAO turmaDAO;

    public TurmaService() {
        this.turmaDAO = new TurmaDAO();
    }

    public void registrarTurma() {
        Turma turma = new Turma();
        turmaDAO.save(turma);
    }

    public void deletarTurma(int id) {
        turmaDAO.delete(id);
    }

}
