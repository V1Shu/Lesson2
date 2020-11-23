package ru.innopolis.university.lesson11.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT = 5678;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT,0, InetAddress.getByName("localhost"));

        Socket socket = serverSocket.accept();

        InputStream fromClient = socket.getInputStream();
        OutputStream toClient = socket.getOutputStream();
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));
        BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(toClient));

        String message;
        while ((message = clientReader.readLine()) != null) {
            System.out.println("Server read: " + message);
            clientWriter.write("\"" + message + "\" received \n");
            clientWriter.flush();
        }
    }
}
