package ru.innopolis.university.lesson19.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl  implements ConnectionManager {

    public static final ConnectionManager INSTANCE = new ConnectionManagerImpl();

    public static ConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "postgres");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
