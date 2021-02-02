package ru.innopolis.university.lesson22.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {

    private Buyer buyer;

    @BeforeEach
    void CreateBuyer() {
        buyer = new Buyer(1L, "Ivan");
    }

    @Test
    void BuyerCreation() {
        assertEquals(buyer.getId(), 1L);
        assertEquals(buyer.getName(), "Ivan");
    }

    @Test
    void BuyerSetters() {
        buyer.setId(3L);
        buyer.setName("Nikolay");

        assertEquals(buyer.getId(), 3L);
        assertEquals(buyer.getName(), "Nikolay");
    }
}