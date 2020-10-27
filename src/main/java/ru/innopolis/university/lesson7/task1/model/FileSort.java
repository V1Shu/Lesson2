package ru.innopolis.university.lesson7.task1.model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Logger;

public class FileSort {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(FileSort.class));
    private static ArrayList<String> list = new ArrayList();

    public static void readFile(String nameOfFile) {
        try(DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream(nameOfFile))) {
            while(dataInputStream.available() > 0) {
                addWord(dataInputStream.readLine());
            }
        } catch (IOException exception) {
            LOGGER.info(exception.getMessage());
        }
    }

    public static void printFile(String fileName) {
        try(DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream(fileName))) {
            while (dataInputStream.available() > 0) {
                LOGGER.info(dataInputStream.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void addWord(String word) {
        if (!list.contains(word.toLowerCase())) {
            list.add(word);
        }
    }

    public static void saveSortedList(String nameOfFile) {
        sortListByAlphabet();
        try(OutputStreamWriter dataOutputStream = new OutputStreamWriter(
                new FileOutputStream(nameOfFile), StandardCharsets.UTF_8)) {
            for (String str : list) {
                dataOutputStream.write(str + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
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
