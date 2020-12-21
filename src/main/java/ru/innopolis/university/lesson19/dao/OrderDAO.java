package ru.innopolis.university.lesson19.dao;

import ru.innopolis.university.lesson19.model.Order;

public interface OrderDAO {
    Long addOrder(Order order);
    Order getOrderById(Long id);
    boolean deleteOrder(Long id);
}
