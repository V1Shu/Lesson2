package ru.innopolis.university.lesson8;

import ru.innopolis.university.lesson8.services.ServiceMethods;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * test calculating factorial using threads
 * @author v.shulepov
 */
public class Main {
    /**
     * count of threads using for calculate factorial
     */
    private static final int COUNT_OF_THREADS = 10;
    /**
     * count of elements in integer ArrayList
     */
    private static final int COUNT_OF_ARRAY_ELEMENTS = 1000;
    private static long startTime = 0;

    public static void main(String[] args) {
        ArrayList<Integer> integerArray = new ArrayList<>();
        ServiceMethods.fillNumberArray(integerArray, COUNT_OF_ARRAY_ELEMENTS);
        integerArray.forEach(System.out::println);
        System.out.println("========================RESULT============================");
        startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_OF_THREADS);
        for (int count = 0; count < integerArray.size(); count++) {
            int finalCount = count;
            executorService.submit(() -> System.out.println(ServiceMethods.factorial(integerArray.get(finalCount))));
        }
    }
}
