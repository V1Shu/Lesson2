package ru.innopolis.university.lesson7.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class FileSort {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(FileSort.class));
    private static ArrayList<String> list = new ArrayList<>();

    public static void readFile(String nameOfFile) {
        try(DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream(nameOfFile))) {
            while(dataInputStream.available() > 0) {
                addWord(dataInputStream.readUTF());
            }
        } catch (IOException exception) {
            LOGGER.info(exception.getMessage());
        }
        for(String str : list) {
            LOGGER.info(str);
        }
    }

    public static void writeTestFile(String nameOfFile, int countOfWords) {
        try(DataOutputStream dataOutputStream = new DataOutputStream(
                new FileOutputStream(nameOfFile))) {
            for(int count = 0; count < countOfWords; count++) {
                dataOutputStream.writeUTF(randomString());
            }
        } catch (IOException exception) {
            LOGGER.info(exception.getMessage());
        }
    }

    private static String randomString() {
        Random random = new Random();
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = random.nextInt(30);

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void printList() {
        for(String str : list) {
            LOGGER.info(str);
        }
    }

    private static void addWord(String word) {
        if (!list.contains(word)) {
            list.add(word);
        }
    }

    public static void saveSortedList(String nameOfFile) {

    }

    private static void sortListByAlphabet() {
        for (int i = 1; i < list.size(); i++) {
            String current = list.get(i);
            int j = i - 1;
            while (j >= 0 && current.compareTo(list.get(j)) < 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }
}
