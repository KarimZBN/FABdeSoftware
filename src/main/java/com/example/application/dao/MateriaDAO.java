package com.example.application.dao;

import com.example.application.data.entity.Materia;
import com.example.application.data.connection.GetConnectionDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO {

    public void save(Materia materia) {
        String sql = "INSERT INTO Materia (nome) VALUES (?)";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, materia.getNome());
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    materia.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saving materia: " + e.getMessage());
        }
    }

    public List<Materia> findAll() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM Materia";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Materia materia = new Materia(rs.getString("nome"));
                materia.setId(rs.getInt("id"));
                materias.add(materia);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching materias: " + e.getMessage());
        }
        return materias;
    }

    public Materia findById(int id) {
        String sql = "SELECT * FROM Materia WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Materia materia = new Materia(rs.getString("nome"));
                    materia.setId(rs.getInt("id"));
                    return materia;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching materia by id: " + e.getMessage());
        }
        return null;
    }

    public void update(Materia materia) {
        String sql = "UPDATE Materia SET nome = ? WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, materia.getNome());
            pstmt.setInt(2, materia.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating materia: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Materia WHERE id = ?";
        try (Connection conn = GetConnectionDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting materia: " + e.getMessage());
        }
    }
}
