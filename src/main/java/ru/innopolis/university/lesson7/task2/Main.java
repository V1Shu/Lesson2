package ru.innopolis.university.lesson7.task2;

import ru.innopolis.university.lesson7.task2.model.FileGenerator;
import ru.innopolis.university.lesson7.task2.service.ServiceMethods;

import java.io.IOException;

/**
 * Generate Files with random words
 * @author v.shulepov
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileGenerator.getFiles("C:\\java\\homework\\src\\main\\java\\ru\\innopolis\\university\\lesson7\\task2\\test",
                2,5, ServiceMethods.generateWordArray(1000),2);
    }
}
