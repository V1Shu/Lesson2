package ru.innopolis.university.lesson22.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void CreateProduct() {
        product = new Product(1L, "Meat", 54);
    }

    @Test
    void ProductCreation() {
        assertEquals(product.getId(), 1L);
        assertEquals(product.getName(), "Meat");
        assertEquals(product.getPrice(), 54);
    }

    @Test
    void OrderSetters() {
        product.setId(5L);
        product.setName("Milk");
        product.setPrice(20);

        assertEquals(product.getId(), 5L);
        assertEquals(product.getName(), "Milk");
        assertEquals(product.getPrice(), 20);
    }
}