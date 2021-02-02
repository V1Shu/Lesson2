package ru.innopolis.university.lesson22.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.innopolis.university.lesson22.connection.ConnectionManagerImpl;
import ru.innopolis.university.lesson22.model.Product;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductDAOImplTest {

    @Mock
    Connection connection;

    @Mock
    private Product product;

    @BeforeEach
    void CreateProduct() {
        product = new Product(5, "Onion", 37);
    }

    @Test
    void addProduct() {
        when().thenReturn();
    }

    @Test
    void getProductById() {
    }

    @Test
    void editProduct() {
    }

    @Test
    void deleteProduct() {
    }
}