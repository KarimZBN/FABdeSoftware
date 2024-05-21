package com.example.application.dao;

import com.example.application.data.entity.Professor;
import com.example.application.data.connection.GetConnectionDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public void save(Professor professor) {
        String sql = "INSERT INTO Professor (nome) VALUES (?)";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, professor.getNome());
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    professor.setId(rs.getInt(1));  // Obtém o ID gerado pelo banco de dados
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saving professor: " + e.getMessage());
        }
    }

    public List<Professor> findAll() {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM Professor";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Professor professor = new Professor(rs.getString("nome"));
                professor.setId(rs.getInt("id"));
                professores.add(professor);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching professors: " + e.getMessage());
        }
        return professores;
    }

    public Professor findById(int id) {
        String sql = "SELECT * FROM Professor WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Professor professor = new Professor(rs.getString("nome"));
                    professor.setId(rs.getInt("id"));
                    return professor;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching professor by id: " + e.getMessage());
        }
        return null;
    }

    public void update(Professor professor) {
        String sql = "UPDATE Professor SET nome = ? WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, professor.getNome());
            pstmt.setInt(2, professor.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating professor: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Professor WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting professor: " + e.getMessage());
        }
    }
}
