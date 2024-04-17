package com.example.springkatte.ServiceLayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/kattehjem";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        // Set up the connection with the DB
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}