package ru.innopolis.university.lesson22.dao;

import ru.innopolis.university.lesson22.model.Order;

public interface OrderDAO {
    Long addOrder(Order order);
    Order getOrderById(Long id);
    boolean deleteOrder(Long id);
}
