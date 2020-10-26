package ru.innopolis.university.lesson7.task1;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(FileSort.class));

    public static void main(String[] args) {
        FileSort.writeTestFile("TestInputFile.txt", 50);
        FileSort.readFile("TestInputFile.txt");
        FileSort.printFile("TestInputFile.txt");
        LOGGER.info("===================================SORTED FILE============================================");
        FileSort.saveSortedList("SortFile.txt");
        FileSort.printFile("SortFile.txt");
    }
}
