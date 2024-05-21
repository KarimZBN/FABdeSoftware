package com.example.application.service;

import com.example.application.dao.MateriaDAO;
import com.example.application.data.entity.Materia;

public class MateriaService {

    private MateriaDAO materiaDAO;

    public MateriaService() {
        this.materiaDAO = new MateriaDAO();
    }

    public void registrarMateria(String nome) {
        Materia materia = new Materia(nome);
        materiaDAO.save(materia);
    }

    public void atualizarMateria(int id, String nome) {
        Materia materia = new Materia(nome);
        materia.setId(id);
        materiaDAO.update(materia);
    }

    public void deletarMateria(int id) {
        materiaDAO.delete(id);
    }

}
