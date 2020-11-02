package ru.innopolis.university.lesson7.task2.service;

import java.util.Random;

/**
 * Service methods
 * @author v.shulepov
 */
public class ServiceMethods {
    private static final Random RANDOM = new Random();

    private ServiceMethods() {}

    /**
     * Generate random word length from 1 to 20
     * @return random word
     */
    public static String randomWord() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = RANDOM.nextInt(20) + 1;

        return RANDOM.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * Generate array of random words, using in filling sentences
     * @param countOfWords int, count of words in array
     * @return array of random words
     */
    public static String[] generateWordArray(int countOfWords) {
        String[] wordArray = new String[countOfWords];
        for (int count = 0; count < countOfWords; count++) {
            wordArray[count] = randomWord() + "FromArray";
        }
        return wordArray;
    }
}
