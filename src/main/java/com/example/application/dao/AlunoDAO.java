package com.example.application.dao;

import com.example.application.data.connection.GetConnectionDatabase;
import com.example.application.data.entity.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {
    public void save(Aluno aluno) {
        String sql = "INSERT INTO Aluno (nome_aluno, id_turma) VALUES (?, ?)";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getTurmaId());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                aluno.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Aluno findByName(String nome) {
        String sql = "SELECT * FROM Aluno WHERE nome_aluno = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aluno(rs.getInt("id_aluno"), rs.getString("nome_aluno"), rs.getInt("id_turma"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
