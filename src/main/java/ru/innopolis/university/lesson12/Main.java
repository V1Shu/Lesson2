package ru.innopolis.university.lesson12;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * test calculating factorial using threads
 * @author v.shulepov
 */
public class Main {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final Random RANDOM = new Random();
    /**
     * count of elements in integer ArrayList
     */
    private static final int COUNT_OF_ARRAY_ELEMENTS = 1;
    /**
     * max integer number to generate to fill arraylist
     */
    private static final int INT_BOUND = 99;

    public static void main(String[] args) {
        LOGGER.info("========================GENERATED ARRAYLIST============================");
        ArrayList<Integer> integerArray = Stream
                .generate(()-> {
                    int generatedNumber = RANDOM.nextInt(INT_BOUND);
                    LOGGER.info(generatedNumber);
                    return generatedNumber;
                })
                .limit(COUNT_OF_ARRAY_ELEMENTS)
                .collect(Collectors
                        .toCollection(ArrayList::new));


        LOGGER.info("========================RESULT============================");
        integerArray.
                forEach(number ->LOGGER.info(IntStream.
                        rangeClosed(2, number).
                        parallel().
                        mapToObj(BigInteger::valueOf).
                        reduce(BigInteger::multiply).
                        get()));
    }
}
