package ru.innopolis.university.lesson19.dao;

import ru.innopolis.university.lesson19.model.Buyer;

public interface BuyerDAO {
    Long addBuyer(Buyer buyer);
    Buyer getBuyerById(Long id);
    boolean editBuyer(Buyer buyer);
    boolean deleteBuyer(Long id);
}
