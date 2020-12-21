package ru.innopolis.university.lesson19.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Service {
    public static void createBase(Connection connection) {
        try (Statement statement = connection.createStatement();) {
            statement.execute(getTableProduct());
            statement.execute(getTableBuyer());
            statement.execute(getTableOrder());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static String getTableProduct() {
        return "DROP TABLE IF EXISTS product CASCADE;"
                + "CREATE TABLE product ("
                + "id serial primary key,"
                + "name varchar(200) NOT NULL, "
                + "price integer NOT NULL);"
                + "INSERT INTO product (name, price)"
                + "VALUES"
                + "('bread', 30),"
                + "('water', 20),"
                + "('potato', 35)";
    }

    private static String getTableBuyer() {
        return "DROP TABLE IF EXISTS buyer CASCADE;"
                + "CREATE TABLE buyer ("
                + "id serial primary key,"
                + "name varchar(200) NOT NULL);"
                + "INSERT INTO buyer (name)"
                + "VALUES"
                + "('Ivan'),"
                + "('Vera')";
    }

    private static String getTableOrder() {
        return "DROP TABLE IF EXISTS product_order;"
                + "CREATE TABLE product_order ("
                + "id serial primary key,"
                + "buyer serial REFERENCES buyer(id),"
                + "product serial REFERENCES product (id));";
    }
}
