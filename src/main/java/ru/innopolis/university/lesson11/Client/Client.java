package ru.innopolis.university.lesson11.Client;

import ru.innopolis.university.lesson11.Server.Server;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private final static Scanner scanner = new Scanner(System.in);
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) {
        new Client();
    }

   public Client() {
       try {
           Socket socket = new Socket("localhost", Server.SERVER_PORT);

           writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
           reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

           System.out.println("Type your name: ");
           writer.write(scanner.nextLine());

           Resender resend = new Resender();
           resend.start();

           String message = "";
           while (!message.equals("exit")) {
               message = scanner.nextLine();
               writer.write(message);
               writer.flush();
           }
           resend.setStop();
       } catch (UnknownHostException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    private class Resender extends Thread {

        private boolean stoped;

        public void setStop() {
            stoped = true;
        }

        @Override
        public void run() {
            try {
                while (!stoped) {
                    String str = reader.readLine();
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
