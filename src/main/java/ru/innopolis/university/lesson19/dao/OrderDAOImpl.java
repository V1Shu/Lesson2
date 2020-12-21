package ru.innopolis.university.lesson19.dao;

import ru.innopolis.university.lesson19.connection.ConnectionManager;
import ru.innopolis.university.lesson19.connection.ConnectionManagerImpl;
import ru.innopolis.university.lesson19.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO {
    private static final ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();


    @Override
    public Long addOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM product_order WHERE id = ?")) {
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Order(
                            resultSet.getLong(1),
                            new BuyerDAOImpl().getBuyerById(resultSet.getLong(2)),
                            new ProductDAOImpl().getProductById(resultSet.getLong(3))
                    );
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteOrder(Long id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM product_order WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
