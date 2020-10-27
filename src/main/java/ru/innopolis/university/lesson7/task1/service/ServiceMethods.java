package ru.innopolis.university.lesson7.task1.service;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.logging.Logger;

public class ServiceMethods {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ServiceMethods.class));

    public static void writeTestFile(String nameOfFile, int countOfWords) {
        try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter (
                new FileOutputStream(nameOfFile), StandardCharsets.UTF_8)) {
            for(int count = 0; count < countOfWords; count++) {
                outputStreamWriter.write(randomString() + "\n");
            }
        } catch (IOException exception) {
            LOGGER.info(exception.getMessage());
        }
    }

    private static String randomString() {
        Random random = new Random();
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = random.nextInt(30) + 1;

        return random.ints(leftLimit, rightLimit)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
