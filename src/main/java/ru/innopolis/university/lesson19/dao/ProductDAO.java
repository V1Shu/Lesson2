package ru.innopolis.university.lesson19.dao;

import ru.innopolis.university.lesson19.model.Product;

public interface ProductDAO {
    Long addProduct(Product product);
    Product getProductById(Long id);
    boolean editProduct(Product product);
    boolean deleteProduct(Long id);
}
