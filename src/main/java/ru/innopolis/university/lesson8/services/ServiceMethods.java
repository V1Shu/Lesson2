package ru.innopolis.university.lesson8.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * Service methods
 * @author v.shulepov
 */
public class ServiceMethods {
    private static final Random RANDOM = new Random();
    /**
     * max integer number to generate to fill arraylist
     */
    private static final int INT_BOUND = 99;

    /**
     * filling arraylist by random integers (from 0 to 99
     * @param integersArray arraylist needed to fill
     * @param countOfNumbers count of numbers for filling arraylist
     */
    public static void fillNumberArray(ArrayList<Integer> integersArray, int countOfNumbers) {
        for (int count = 0; count < countOfNumbers; count++) {
            integersArray.add(RANDOM.nextInt(INT_BOUND));
        }
    }

    /**
     * calculates factorial
     * @param number number needed to calculate factorial for
     * @return factorial of input number (BigInteger)
     */
    public static BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
