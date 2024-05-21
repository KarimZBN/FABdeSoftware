package com.example.application.dao;

import com.example.application.data.entity.Aula;
import com.example.application.data.connection.GetConnectionDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AulaDAO {

    public List<Aula> findAll() {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT * FROM Aula";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                aulas.add(new Aula(rs.getInt("id_aula"), rs.getString("conteudo_aula"), rs.getInt("numero_aula"), rs.getInt("id_materia_turma")));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching aulas: " + e.getMessage());
        }
        return aulas;
    }

    public Aula findById(int id) {
        String sql = "SELECT * FROM Aula WHERE id_aula = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Aula(rs.getInt("id_aula"), rs.getString("conteudo_aula"), rs.getInt("numero_aula"), rs.getInt("id_materia_turma"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching aula by id: " + e.getMessage());
        }
        return null;
    }

    public void save(Aula aula) {
        String sql = "INSERT INTO Aula (conteudo_aula, numero_aula, id_materia_turma) VALUES (?, ?, ?)";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, aula.getConteudo());
            pstmt.setInt(2, aula.getNumeroAula());
            pstmt.setInt(3, aula.getIdMateriaTurma());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving aula: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Aula WHERE id_aula = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting aula: " + e.getMessage());
        }
    }
}
