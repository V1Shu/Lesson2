package ru.innopolis.university.lesson22.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Service {

    private static final Logger LOGGER = LogManager.getLogger("info");

    public static void createBase(Connection connection) {
        try (Statement statement = connection.createStatement();) {
            statement.execute(getTableProduct());
            statement.execute(getTableBuyer());
            statement.execute(getTableOrder());
            statement.execute(getTableLogger());
        } catch (SQLException throwables) {
            LOGGER.error(throwables.getStackTrace());
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
                + "product serial REFERENCES product (id));"
                + "INSERT INTO product_order (buyer, product)"
                + "VALUES"
                + "(1, 1),"
                + "(1, 3),"
                + "(2, 1),"
                + "(2, 2);";
    }

    private static String getTableLogger() {
        return "DROP TABLE IF EXISTS logger;"
                + "CREATE TABLE logger ("
                + "log_id serial primary key, "
                + "entry_date timestamp, "
                + "logger varchar(100), "
                + "log_level varchar(100), "
                + "message text, "
                + "exception text);";
    }
}
