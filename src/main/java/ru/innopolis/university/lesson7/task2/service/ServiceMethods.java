package ru.innopolis.university.lesson7.task2.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class ServiceMethods {
    private static final Random RANDOM = new Random();

    private ServiceMethods() {}

    public static String randomWord() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = RANDOM.nextInt(20) + 1;

        return RANDOM.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String[] generateWordArray(int countOfWords) {
        String[] wordArray = new String[countOfWords];
        for (int count = 0; count < countOfWords; count++) {
            wordArray[count] = randomWord() + "FromArray";
        }
        return wordArray;
    }
}
