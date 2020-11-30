package ru.innopolis.university.lesson11.server;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Server path of chat
 * @author v.shulepov
 */
public class Server {
    private static final Logger LOGGER = LogManager.getLogger(Server.class);
    /**
     * list of connected client
     */
    private final List<User> clients;
    private ServerSocket serverSocket;
    public static final int SERVER_PORT = 8286;

    public static void main(String[] args){
        new Server().run();
    }

    /**
     * Create new list of users on start server
     */
    public Server() {
        this.clients = new ArrayList<>();
    }

    /**
     * start server, create sockets, waiting for users
     */
    public void run(){
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
        } catch (IOException e) {
            LOGGER.info("Can't open ServerSocket");
        }
        LOGGER.info("Port" + SERVER_PORT + " is now open.");

        while (true) {
            Socket client = null;
            try {
                client = serverSocket.accept();
            } catch (IOException e) {
                LOGGER.info("Can't create client");
            }

            String nickname = null;
            try {
                nickname = (new Scanner( client.getInputStream() )).nextLine();
            } catch (IOException e) {
                LOGGER.info("Can't take nickname line");
            }
            LOGGER.info("New Client: \"" + nickname + "\"\n\t     Host:" + client.getInetAddress().getHostAddress());

            User newUser = new User(client, nickname);

            this.clients.add(newUser);

            new Thread(new UserHandler(this, newUser)).start();
        }
    }

    /**
     * remove users from list of connected users
     * @param user
     */
    public void removeUser(User user) {
        this.clients.remove(user);
    }

    /**
     * send input message to all connected users
     * @param msg input message
     * @param userSender sender of message
     */
    public void broadcastMessages(String msg, User userSender) {
        for (User client : this.clients) {
            client.getOutStream().println(
                    userSender.toString() + " : " + msg);
        }
    }

    /**
     * print list of connected users
     */
    public void broadcastAllUsers() {
        for (User client : this.clients) {
            client.getOutStream().println(this.clients);
        }
    }

    /**
     * send private message
     * @param msg input message
     * @param userSender sender of message
     * @param user target user
     */
    public void sendMessageToUser(String msg, User userSender, String user){
        boolean find = false;
        for (User client : this.clients) {
            if (client.getNickname().equals(user) && client != userSender) {
                find = true;
                userSender.getOutStream().println(userSender.toString() + " -> " + client.toString() +": " + msg);
                client.getOutStream().println(
                        "(Private)" + userSender.toString() + " : " + msg);
            }
        }
        if (!find) {
            userSender.getOutStream().println(userSender.toString() + " -> (no one!): " + msg);
        }
    }
}

/**
 * User Handler
 * @author v.shulepov
 */
class UserHandler implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(UserHandler.class);

    private final Server server;
    private final User user;

    public UserHandler(Server server, User user) {
        this.server = server;
        this.user = user;
        this.server.broadcastAllUsers();
    }

    /**
     * Used for read message and sent
     * To send private print "@<username> message"
     */
    public void run() {
        String message;

        Scanner sc = new Scanner(this.user.getInputStream());
        while (sc.hasNextLine()) {
            message = sc.nextLine();

            if (message.charAt(0) == '@'){
                if(message.contains(" ")){
                    LOGGER.info("private msg : " + message);
                    int firstSpace = message.indexOf(" ");
                    String userPrivate= message.substring(1, firstSpace);
                    server.sendMessageToUser(
                            message.substring(
                                    firstSpace+1), user, userPrivate
                    );
                }
            }else{
                server.broadcastMessages(message, user);
            }
        }
        server.removeUser(user);
        this.server.broadcastAllUsers();
        sc.close();
    }
}

/**
 * User
 * @author v.shulepov
 */
class User {
    private static final Logger LOGGER = LogManager.getLogger(User.class);

    private PrintStream streamOut;
    private InputStream streamIn;
    private String nickname;

    public User(Socket client, String name){
        try {
            this.streamOut = new PrintStream(client.getOutputStream());
            this.streamIn = client.getInputStream();
            this.nickname = name;
        } catch (IOException e) {
            LOGGER.info("Can't create user");
        }
    }

    /**
     * Getters
     */
    public PrintStream getOutStream(){
        return this.streamOut;
    }

    public InputStream getInputStream(){
        return this.streamIn;
    }

    public String getNickname(){
        return this.nickname;
    }

    public String toString(){
        return this.getNickname();
    }
}