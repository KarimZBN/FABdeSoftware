package com.example.application.dao;

import com.example.application.data.entity.Turma;
import com.example.application.data.connection.GetConnectionDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {

    public void save(Turma turma) {
        String sql = "INSERT INTO Turma DEFAULT VALUES";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    turma.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saving turma: " + e.getMessage());
        }
    }

    public List<Turma> findAll() {
        List<Turma> turmas = new ArrayList<>();
        String sql = "SELECT * FROM Turma";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setId(rs.getInt("id"));
                turmas.add(turma);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching turmas: " + e.getMessage());
        }
        return turmas;
    }

    public Turma findById(int id) {
        String sql = "SELECT * FROM Turma WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Turma turma = new Turma();
                    turma.setId(rs.getInt("id"));
                    return turma;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching turma by id: " + e.getMessage());
        }
        return null;
    }

    public void delete(int id) {
        String sql = "DELETE FROM Turma WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting turma: " + e.getMessage());
        }
    }
}
