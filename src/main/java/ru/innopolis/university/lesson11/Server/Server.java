package ru.innopolis.university.lesson11.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static final int SERVER_PORT = 5678;
    private static final ArrayList<Connection> listOfConnections = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        Socket socket = serverSocket.accept();
        Connection connection = new Connection(socket);
        listOfConnections.add(connection);

        String message;
        while (!"exit".equals(message = connection.getReader().readLine())) {
            System.out.println("Server read: " + message);
            connection.getWriter().write("\"" + message + "\" received \n");
            connection.getWriter().flush();
        }
    }
}
