package ru.innopolis.university.lesson2.task1.errors;

/**
 * Contains errors , needed to call in {@link ru.innopolis.university.lesson2.task1.helloworld.HelloWorld}
 * @author Shulepov Vadim
 */
public class ErrorExamples {
    /**
     * call ArrayOutOfBounds Exception
     */
    public static void arrayOutOfBounds() {
        int[] testIntArray = new int[0];
        int number = testIntArray[0];
    }

    /**
     * Call NullPointerException, if getting null as param
     * @param errorExamples
     */
    public static void nullPointerException(ErrorExamples errorExamples) {
        errorExamples.toString();
    }

    /**
     * Call ArithmeticException by throwing it
     */
    public static void throwException() {
        throw new ArithmeticException();
    }
}
