package ru.innopolis.university.lesson19.dao;

import ru.innopolis.university.lesson19.connection.ConnectionManager;
import ru.innopolis.university.lesson19.connection.ConnectionManagerImpl;
import ru.innopolis.university.lesson19.model.Buyer;

import java.sql.*;

public class BuyerDAOImpl implements BuyerDAO {
    private static final ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public Long addBuyer(Buyer buyer) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO buyer VALUES (DEFAULT , ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, buyer.getName());

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Buyer getBuyerById(Long id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT  * FROM buyer WHERE id = ?")) {
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Buyer(
                            resultSet.getLong(1),
                            resultSet.getString(2));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean editBuyer(Buyer buyer) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE buyer SET name = ? WHERE id = ?")) {
            preparedStatement.setString(1, buyer.getName());
            preparedStatement.setLong(2, buyer.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBuyer(Long id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM buyer WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
