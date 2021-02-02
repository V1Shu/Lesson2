package ru.innopolis.university.lesson22.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Mock
    private Buyer buyer;

    @Mock
    private Product product;

    private Order order;

    @BeforeEach
    void CreateOrder() {
        order = new Order(1L, buyer, product);
    }

    @Test
    void OrderCreation() {
        assertEquals(order.getId(), 1L);
        assertEquals(order.getBuyer(), buyer);
        assertEquals(order.getProduct(), product);
    }

    @Test
    void OrderSetters() {
        Buyer newBuyer = new Buyer(5L, "Vera");
        Product newProduct = new Product(7L, "Milk", 27);

        order.setId(2L);
        order.setBuyer(newBuyer);
        order.setProduct(newProduct);

        assertEquals(order.getId(), 2L);
        assertEquals(order.getBuyer(), newBuyer);
        assertEquals(order.getProduct(), newProduct);
    }
}