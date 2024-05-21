package com.example.application.service;

import com.example.application.dao.ProfessorDAO;
import com.example.application.data.entity.Professor;

public class ProfessorService {

    private ProfessorDAO professorDAO;

    public ProfessorService() {
        this.professorDAO = new ProfessorDAO();
    }

    public void registrarProfessor(String nome) {
        Professor professor = new Professor(nome);
        professorDAO.save(professor);
    }

}
