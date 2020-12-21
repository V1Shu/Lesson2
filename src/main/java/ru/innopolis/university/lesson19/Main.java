package ru.innopolis.university.lesson19;

import ru.innopolis.university.lesson19.connection.ConnectionManagerImpl;
import ru.innopolis.university.lesson19.services.Service;

public class Main {
    public static void main(String[] args) {
        ConnectionManagerImpl connectionManager = new ConnectionManagerImpl();

        Service.createBase(connectionManager.getConnection());


    }
}
