package ru.innopolis.university.lesson3.task1;

/**
 * Class for test MathBox
 * @author v.shulepov
 */
public class Main {

    public static void main(String[] args) {
        Number[] numbers = new Number[8];
        testInput(numbers);

        MathBox mathB = new MathBox(numbers);

        System.out.println("Input ArrayList: " + mathB.toString());
        mathB.removeElement(5);
        System.out.println("Array after remove element: " + mathB.toString());
        System.out.println("Sum of all elements: " + mathB.summator());
        mathB.splitter(3.0);
        System.out.println("ArrayList after splitter method: " + mathB.toString());
    }

    /**
     * Fill array by test numbers
     * @param numbers array of numbers
     */
    public static void testInput(Number[] numbers) {
        numbers[0] = (byte) 5;
        numbers[1] = 2;
        numbers[2] = 5.7;
        numbers[3] = 4.2f;
        numbers[4] = (byte) 2;
        numbers[5] = 5;
        numbers[6] = 4.2f;
        numbers[7] = 2.3;
    }
}
