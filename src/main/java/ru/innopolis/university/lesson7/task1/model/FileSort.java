package ru.innopolis.university.lesson7.task1.model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Read text file, sort and save as new file
 * @author v.shulepov
 */
public class FileSort {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(FileSort.class));
    private static final ArrayList<String> list = new ArrayList<>();

    private FileSort() {}

    /**
     * read file
     * @param nameOfFile file name
     */
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

    /**
     * print information from file
     * @param fileName file name
     */
    public static void printFile(String fileName) {
        try(DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream(fileName))) {
            while (dataInputStream.available() > 0) {
                String info = dataInputStream.readLine();
                LOGGER.info(info);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * add word to Array list of words
     * @param word input word
     */
    private static void addWord(String word) {
        if (!list.contains(word.toLowerCase())) {
            list.add(word);
        }
    }

    /**
     * save sorted list to file
     * @param nameOfFile name of saving file
     */
    public static void saveSortedList(String nameOfFile) {
        sortListByAlphabet();
        try(OutputStreamWriter dataOutputStream = new OutputStreamWriter(
                new FileOutputStream(nameOfFile), StandardCharsets.UTF_8)) {
            for (String str : list) {
                dataOutputStream.write(str + "\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * sort array list by alphabet
     */
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
