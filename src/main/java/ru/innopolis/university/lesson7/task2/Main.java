package ru.innopolis.university.lesson7.task2;

import ru.innopolis.university.lesson7.task2.model.FileGenerator;
import ru.innopolis.university.lesson7.task2.service.ServiceMethods;

import java.io.IOException;

/**
 * Generate Files with random words
 * @author v.shulepov
 */
public class Main {
    private static final String PATH = System.getProperty("user.home");
    private static final int COUNT_OF_FILES = 5;
    /**
     * size of output file in bytes
     */
    private static final int SIZE_OF_FILE = 1024;
    private static final int COUNT_OF_WORDS_IN_ARRAY = 1000;
    private static final int PROBABILITY = 2;

    public static void main(String[] args) throws IOException {
        FileGenerator.getFiles(PATH,
                COUNT_OF_FILES,
                SIZE_OF_FILE,
                ServiceMethods.generateWordArray(COUNT_OF_WORDS_IN_ARRAY),
                PROBABILITY);
    }
}
