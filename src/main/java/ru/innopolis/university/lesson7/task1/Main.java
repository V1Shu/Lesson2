package ru.innopolis.university.lesson7.task1;

import ru.innopolis.university.lesson7.task1.model.FileSort;
import ru.innopolis.university.lesson7.task1.service.ServiceMethods;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getGlobal();

    public static void main(String[] args) {
        String nameOfFile = "TestInputFile.txt";
        ServiceMethods.writeTestFile(nameOfFile, 50);
        FileSort.readFile(nameOfFile);
        FileSort.printFile(nameOfFile);
        LOGGER.info("===================================SORTED FILE============================================");
        FileSort.saveSortedList("SortFile.txt");
        FileSort.printFile("SortFile.txt");
    }
}
