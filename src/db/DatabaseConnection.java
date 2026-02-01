package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String url;
    private final String user;
    private final String password;

    public DatabaseConnection(String url, String user, String password) {
        this.url = "jdbc:postgresql://localhost:5432/postgres";
        this.user = "postgres";
        this.password = "1234";
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
