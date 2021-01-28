package ru.innopolis.university.lesson22.connection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl  implements ConnectionManager {

    private static final Logger LOGGER = LogManager.getRootLogger();

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
            LOGGER.error(throwables.getMessage());
        }
        //LOGGER.info("Connection create");
        return connection;
    }
}
