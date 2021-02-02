package ru.innopolis.university.lesson22;

import org.apache.log4j.BasicConfigurator;
import ru.innopolis.university.lesson22.connection.ConnectionManagerImpl;
import ru.innopolis.university.lesson22.services.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger("system");

    private static final String INSERT_SQL = "INSERT INTO product " + "(name, price) VALUES (?, ?)";

    public static void main(String[] args) {

        BasicConfigurator.configure();

        LOGGER.debug("Application start");

        ConnectionManagerImpl connectionManager = new ConnectionManagerImpl();

        try (Connection connection = connectionManager.getConnection()) {
            Service.createBase(connection);
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)){

                Logger dbLogger = LogManager.getLogger("events");

                preparedStatement.setString(1,"milk");
                preparedStatement.setInt(2,35);
                preparedStatement.executeUpdate();

                dbLogger.info("milk added to statement");

                preparedStatement.setString(1,"onion");
                preparedStatement.setInt(2,15);
                preparedStatement.addBatch();

                dbLogger.info("onion added to batch");

                preparedStatement.setString(1,"meat");
                preparedStatement.setInt(2,50);
                preparedStatement.addBatch();

                dbLogger.info("meat added to batch");

                Savepoint savepoint = connection.setSavepoint("products savepoint");

                dbLogger.info("create savepoint");

                preparedStatement.executeBatch();

                dbLogger.info("batch executed");

                connection.commit();

                dbLogger.info("connection commit");

                preparedStatement.setString(1, "drill");
                preparedStatement.setInt(2, 2000);
                preparedStatement.execute();

                connection.rollback(savepoint);

                connection.commit();

            } catch (SQLException sqlException) {
                LOGGER.error(sqlException.getMessage());
            }

        } catch (SQLException throwables) {
            LOGGER.error(throwables.getMessage());
        }

        LOGGER.debug("Application stop");
    }
}
