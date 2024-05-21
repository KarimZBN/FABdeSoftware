package com.example.application.dao;

import com.example.application.data.entity.Materia_Turma;
import com.example.application.data.connection.GetConnectionDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Materia_TurmaDAO {

    public void save(Materia_Turma materia_Turma) {
        String sql = "INSERT INTO Materia_Turma (id_materia, id_turma, id_professor) VALUES (?, ?, ?)";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, materia_Turma.getIdMateria());
            pstmt.setInt(2, materia_Turma.getIdTurma());
            pstmt.setInt(3, materia_Turma.getIdProfessor());
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saving Materia_Turma: " + e.getMessage());
        }
    }

    public List<Materia_Turma> findAll() {
        List<Materia_Turma> materia_Turmas = new ArrayList<>();
        String sql = "SELECT * FROM Materia_Turma";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                materia_Turmas.add(new Materia_Turma(
                    rs.getInt("id_materia"),
                    rs.getInt("id_turma"),
                    rs.getInt("id_professor")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching Materia_Turmas: " + e.getMessage());
        }
        return materia_Turmas;
    }

    public Materia_Turma findById(int id) {
        String sql = "SELECT * FROM Materia_Turma WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Materia_Turma(
                    rs.getInt("id_materia"),
                    rs.getInt("id_turma"),
                    rs.getInt("id_professor")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error fetching Materia_Turma by id: " + e.getMessage());
        }
        return null;
    }

    public void update(Materia_Turma Materia_Turma) {
        String sql = "UPDATE Materia_Turma SET id_materia = ?, id_turma = ?, id_professor = ? WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Materia_Turma.getIdMateria());
            pstmt.setInt(2, Materia_Turma.getIdTurma());
            pstmt.setInt(3, Materia_Turma.getIdProfessor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating Materia_Turma: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Materia_Turma WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting Materia_Turma: " + e.getMessage());
        }
    }
}
