package ru.innopolis.university.lesson19.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Service {
    public static void createBase(Connection connection) {
        try (Statement statement = connection.createStatement();) {
            statement.execute("DROP TABLE IF EXISTS product;"
            + "CREATE TABLE product ("
            + "id serial primary key,"
            + "name varchar(200) NOT NULL, "
            + "price integer NOT NULL);"
            + "INSERT INTO product (name, price)"
            + "VALUES"
            + "('bread', 30),"
            + "('water', 20),"
            + "('potato', 35)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
