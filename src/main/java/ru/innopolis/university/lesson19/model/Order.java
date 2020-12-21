package ru.innopolis.university.lesson19.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private long id;
    private Buyer buyer;
    private List<Product> productList;
}
