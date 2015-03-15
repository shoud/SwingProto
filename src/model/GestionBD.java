package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBD {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(Tags.dbName);
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(15);
                statement.executeUpdate("create table if not exists " + Tags.tableName + " (file text primary key, tags text)");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                closeConnection();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}