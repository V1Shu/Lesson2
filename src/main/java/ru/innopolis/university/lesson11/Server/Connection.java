package ru.innopolis.university.lesson11.Server;

import java.io.*;
import java.net.Socket;

public class Connection {
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;

        InputStream fromClient = socket.getInputStream();
        OutputStream toClient = socket.getOutputStream();
        reader = new BufferedReader(new InputStreamReader(fromClient));
        writer = new BufferedWriter(new OutputStreamWriter(toClient));
    }

    public BufferedReader getReader() {
        return reader;
    }

    public BufferedWriter getWriter() {
        return writer;
    }
}
