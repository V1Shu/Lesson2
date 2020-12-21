package ru.innopolis.university.lesson19.dao;

import ru.innopolis.university.lesson19.connection.ConnectionManager;
import ru.innopolis.university.lesson19.connection.ConnectionManagerImpl;
import ru.innopolis.university.lesson19.model.Buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BuyerDAOImpl implements BuyerDAO{
    private static final ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public Long addBuyer(Buyer buyer) {
        /*try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
""
             ))*/


        return null;
    }

    @Override
    public Buyer getBuyerById(Long id) {
        return null;
    }

    @Override
    public boolean editBuyer(Buyer buyer) {
        return false;
    }

    @Override
    public boolean deleteBuyer(Long id) {
        return false;
    }
}
