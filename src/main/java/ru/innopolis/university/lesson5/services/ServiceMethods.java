package ru.innopolis.university.lesson5.services;

import java.util.Random;

/**
 * Service methods using for Animal and AnimalList objects
 * @author v.shulepov
 */
public class ServiceMethods {
    private static final Random random = new Random();

    private ServiceMethods(){}
    /**
     * Generate random string with 6 length
     * @return string with random lowercase english letters
     */
    public static String randomName() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
