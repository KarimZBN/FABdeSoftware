package com.example.application.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionDatabase {
// trocar diretório
    private static final String URL = "jdbc:sqlite:C:\\Users\\vness\\Documents\\Univille\\fabrica de software\\faltas\\falta.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load SQLite JDBC driver");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
