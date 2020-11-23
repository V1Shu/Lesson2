package ru.innopolis.university.lesson11.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Server {
    public static final int SERVER_PORT = 5678;
    private static final Map<Connection, String> connections = new Map<Connection, String>() {
        @Override
        public int size() {
            return this.size();
        }

        @Override
        public boolean isEmpty() {
            return this.size() == 0;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public String get(Object key) {
            return this.get(key);
        }

        @Override
        public String put(Connection key, String value) {
            return null;
        }

        @Override
        public String remove(Object key) {
            return this.remove(key);
        }

        @Override
        public void putAll(Map<? extends Connection, ? extends String> m) {

        }

        @Override
        public void clear() {
            this.clear();
        }

        @Override
        public Set<Connection> keySet() {
            return null;
        }

        @Override
        public Collection<String> values() {
            return null;
        }

        @Override
        public Set<Entry<Connection, String>> entrySet() {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    };

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT,0, InetAddress.getByName("localhost"));

        Socket socket = serverSocket.accept();
        Connection connection = new Connection(socket);
        //connections.put(connection, connection.getReader().readLine());

        String message;
        while ((message = connection.getReader().readLine()) != null) {
            System.out.println("Server read: " + message);
            connection.getWriter().write("\"" + message + "\" received \n");
            connection.getWriter().flush();
        }
    }
}
