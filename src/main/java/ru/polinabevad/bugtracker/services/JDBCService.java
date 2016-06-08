package ru.polinabevad.bugtracker.services;

import org.postgresql.Driver;

import java.sql.*;

/**
 * Тестовый для JDBC подключений
 */
public class JDBCService {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        java.sql.Driver driver = new Driver();
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/BugTrackerBase", "postgres", "AhuleB2KS");
        Statement query = con.createStatement();

        ResultSet resultSet = query.executeQuery("SELECT * FROM \"testTable\"");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
        }

    }
}

