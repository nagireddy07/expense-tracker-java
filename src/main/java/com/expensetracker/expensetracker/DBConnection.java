package com.expensetracker.expensetracker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/expensetracker";
    private static final String USER = "postgres"; // change if different
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to PostgreSQL successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to DB");
            e.printStackTrace();
        }
        return conn;
    }
}