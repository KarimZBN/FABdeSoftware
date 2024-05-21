package com.example.application.service;

import com.example.application.dao.Materia_TurmaDAO;
import com.example.application.data.entity.Materia_Turma;

public class Materia_TurmaService {

    private Materia_TurmaDAO Materia_TurmaDAO;

    public Materia_TurmaService() {
        this.Materia_TurmaDAO = new Materia_TurmaDAO();
    }

    public void registrarMateria_Turma(int idMateria, int idTurma, int idProfessor) {
        Materia_Turma Materia_Turma = new Materia_Turma(idMateria, idTurma, idProfessor);
        Materia_TurmaDAO.save(Materia_Turma);
    }

}
