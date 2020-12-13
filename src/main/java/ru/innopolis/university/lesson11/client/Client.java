package ru.innopolis.university.lesson11.client;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import static ru.innopolis.university.lesson11.server.Server.SERVER_PORT;

public class Client {
    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    private final String host;
    private final int port;

    public static void main(String[] args){
        new Client("127.0.0.1", SERVER_PORT).run();
    }

    /**
     * client constructor
     * @param host server address
     * @param port server port
     */
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * run client
     */
    public void run(){
        Socket client = null;
        try {
            client = new Socket(host, port);
        } catch (IOException e) {
            LOGGER.info("Can't open socket");
        }
        LOGGER.info("Client successfully connected to server!");

        PrintStream output = null;
        try {
            output = new PrintStream(client.getOutputStream());
        } catch (IOException e) {
            LOGGER.info("Can't create PrintStream");
        }

        Scanner sc = new Scanner(System.in);
        LOGGER.info("Enter a nickname: ");
        String nickname = sc.nextLine();

        output.println(nickname);

        try {
            new Thread(new ReceivedMessagesHandler(client.getInputStream())).start();
        } catch (IOException e) {
            LOGGER.info("Can't create new thread");
        }

        LOGGER.info("Messages: \n");

        while (sc.hasNextLine()) {
            String message = sc.nextLine();
            if ("exit".equals(message)) {
                break;
            } else {
                output.println(message);
            }
        }

        output.close();
        sc.close();
        try {
            client.close();
        } catch (IOException e) {
            LOGGER.info("Can't close socket");
        }
    }
}

/**
 * class for take input message
 */
class ReceivedMessagesHandler implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(ReceivedMessagesHandler.class);

    private final InputStream server;

    public ReceivedMessagesHandler(InputStream server) {
        this.server = server;
    }

    /**
     * run handler
     */
    public void run() {
        Scanner s = new Scanner(server);
        while (s.hasNextLine()) {
            LOGGER.info(s.nextLine());
        }
        s.close();
    }
}