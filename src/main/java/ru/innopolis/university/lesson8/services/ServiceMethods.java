package ru.innopolis.university.lesson8.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class ServiceMethods {
    private static final Random RANDOM = new Random();

    public static void fillNumberArray(ArrayList<Integer> integersArray, int countOfNumbers) {
        for (int count = 0; count < countOfNumbers; count++) {
            integersArray.add(RANDOM.nextInt(99));
        }
    }

    public static BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
