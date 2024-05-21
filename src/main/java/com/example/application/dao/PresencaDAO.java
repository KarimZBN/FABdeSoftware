package com.example.application.dao;

import com.example.application.data.connection.GetConnectionDatabase;
import com.example.application.data.entity.Presenca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PresencaDAO {

    public void save(Presenca presenca) {
        String sql = "INSERT INTO Presenca (id_aluno, id_aula, presente) VALUES (?, ?, ?)";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, presenca.getAlunoId());
            stmt.setInt(2, presenca.getAulaId());
            stmt.setBoolean(3, presenca.isPresente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Presenca> findByAlunoId(int alunoId) {
        String sql = "SELECT * FROM Presenca WHERE id_aluno = ?";
        List<Presenca> presencas = new ArrayList<>();
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alunoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Presenca presenca = new Presenca(
                    rs.getInt("id_aluno"),
                    rs.getInt("id_aula"),
                    rs.getBoolean("presente")
                );
                presencas.add(presenca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return presencas;
    }
}
