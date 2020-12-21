package ru.innopolis.university.lesson19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private long id;
    private Buyer buyer;
    private Product product;
}
