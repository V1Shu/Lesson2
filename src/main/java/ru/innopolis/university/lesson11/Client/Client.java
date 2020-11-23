package ru.innopolis.university.lesson11.Client;

import ru.innopolis.university.lesson11.Server.Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", Server.SERVER_PORT);

        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        String message;
        System.out.println("Type your name: ");
        while (!(message = scanner.nextLine()).isEmpty()) {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            System.out.println("server echo " + bufferedReader.readLine());
        }
    }
}
