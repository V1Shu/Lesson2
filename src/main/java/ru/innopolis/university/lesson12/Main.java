package ru.innopolis.university.lesson12;

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
        System.out.println("========================GENERATED ARRAYLIST============================");
        ArrayList<Integer> integerArray = Stream
                .generate(()-> {
                    int generatedNumber = RANDOM.nextInt(INT_BOUND);
                    System.out.println(generatedNumber);
                    return generatedNumber;
                })
                .limit(COUNT_OF_ARRAY_ELEMENTS)
                .collect(Collectors
                        .toCollection(ArrayList::new));


        System.out.println("========================RESULT============================");
        integerArray.
                stream().
                forEach((number) ->System.out.println(IntStream.
                        rangeClosed(2, number).
                        parallel().
                        mapToObj(BigInteger::valueOf).
                        reduce(BigInteger::multiply).
                        get()));
    }
}
