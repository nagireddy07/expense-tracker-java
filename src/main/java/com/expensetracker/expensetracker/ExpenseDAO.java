package com.expensetracker.expensetracker;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ExpenseDAO {
    Connection conn = DBConnection.getConnection();

    public void addExpense(Expense exp) {
        String sql = "INSERT INTO expenses (title, amount, category, date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, exp.getTitle());
            ps.setDouble(2, exp.getAmount());
            ps.setString(3, exp.getCategory());
            ps.setDate(4, Date.valueOf(exp.getDate()));
            ps.executeUpdate();
            System.out.println("✅ Expense added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Expense deleted successfully.");
            } else {
                System.out.println("❌ Expense ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateExpense(int id, Expense updated) {
        String sql = "UPDATE expenses SET title=?, amount=?, category=?, date=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, updated.getTitle());
            ps.setDouble(2, updated.getAmount());
            ps.setString(3, updated.getCategory());
            ps.setDate(4, Date.valueOf(updated.getDate()));
            ps.setInt(5, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Expense updated.");
            } else {
                System.out.println("❌ Expense ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Expense> filterByCategory(String category) {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE category = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setAmount(rs.getDouble("amount"));
                e.setCategory(rs.getString("category"));
                e.setDate(rs.getDate("date").toString());
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Expense> filterByDateRange(String fromDate, String toDate) {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE date BETWEEN ? AND ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(fromDate));
            ps.setDate(2, Date.valueOf(toDate));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setAmount(rs.getDouble("amount"));
                e.setCategory(rs.getString("category"));
                e.setDate(rs.getDate("date").toString());
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setAmount(rs.getDouble("amount"));
                e.setCategory(rs.getString("category"));
                e.setDate(rs.getDate("date").toString());
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
