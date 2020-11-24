package ru.innopolis.university.lesson11.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static final int SERVER_PORT = 5678;
    private static final List<Connection> listOfConnections =
            Collections.synchronizedList(new ArrayList<>());
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
        serverSocket = new ServerSocket(SERVER_PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            Connection con = new Connection(socket);
            listOfConnections.add(con);

            con.start();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Connection extends Thread {
        private BufferedReader reader;
        private BufferedWriter writer;
        private Socket socket;

        private String name = "";

        public Connection(Socket socket) {
            this.socket = socket;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                name = reader.readLine();
                /*synchronized (listOfConnections) {
                    Iterator<Connection> iter = listOfConnections.iterator();
                    while (iter.hasNext()) {
                        ((Connection) iter.next()).writer.write(name + " cames now");
                    }
                }*/

                String str = "";
                while (true) {
                    str = reader.readLine();
                    if (str.equals("exit")) break;

                    synchronized (listOfConnections) {
                        Iterator<Connection> iter = listOfConnections.iterator();
                        while (iter.hasNext()) {
                            Connection currentConnection = iter.next();
                            currentConnection.writer.write(name + ": " + str);
                            currentConnection.writer.flush();
                        }
                    }
                }

                /*synchronized (listOfConnections) {
                    Iterator<Connection> iter = listOfConnections.iterator();
                    while (iter.hasNext()) {
                        ((Connection) iter.next()).writer.write(name + " has left");
                    }
                }*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
