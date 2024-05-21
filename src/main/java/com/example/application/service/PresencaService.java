package com.example.application.service;

import com.example.application.dao.PresencaDAO;
import com.example.application.data.entity.Presenca;

import java.util.List;

public class PresencaService {
    private PresencaDAO presencaDAO;

    public PresencaService() {
        presencaDAO = new PresencaDAO();
    }

    public void registrarPresenca(int alunoId, int aulaId, boolean presente) {
        Presenca presenca = new Presenca(alunoId, aulaId, presente);
        presencaDAO.save(presenca);
    }

    public List<Presenca> findByAlunoId(int alunoId) {
        return presencaDAO.findByAlunoId(alunoId);
    }
}
