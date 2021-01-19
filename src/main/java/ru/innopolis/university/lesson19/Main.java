package ru.innopolis.university.lesson19;

import ru.innopolis.university.lesson19.connection.ConnectionManagerImpl;
import ru.innopolis.university.lesson19.services.Service;

import java.sql.*;

public class Main {

private static final String INSERT_SQL = "INSERT INTO product "
                                            + "(name, price) VALUES (?, ?)";

    public static void main(String[] args) {
        ConnectionManagerImpl connectionManager = new ConnectionManagerImpl();

        try (Connection connection = connectionManager.getConnection()) {
            Service.createBase(connection);
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)){
                preparedStatement.setString(1,"milk");
                preparedStatement.setInt(2,35);
                preparedStatement.executeUpdate();

                preparedStatement.setString(1,"onion");
                preparedStatement.setInt(2,15);
                preparedStatement.addBatch();

                preparedStatement.setString(1,"meat");
                preparedStatement.setInt(2,50);
                preparedStatement.addBatch();

                Savepoint savepoint = connection.setSavepoint("products savepoint");

                preparedStatement.executeBatch();

                connection.commit();

                preparedStatement.setString(1, "drill");
                preparedStatement.setInt(2, 2000);
                preparedStatement.execute();

                connection.rollback(savepoint);

                connection.commit();

            } catch (SQLException sqlException) {
                connection.rollback();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
