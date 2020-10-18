package ru.innopolis.university.lesson3.task1;

import java.util.logging.Logger;

/**
 * Class for test MathBox
 * @author v.shulepov
 */
public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(MathBox.class));

    public static void main(String[] args) {
        Number[] numbers = new Number[8];
        testInput(numbers);

        MathBox mathB = new MathBox(numbers);

        String info = "Input ArrayList: " + mathB.toString();
        logger.info(info);
        mathB.removeElement(5);
        info = "Array after remove element: " + mathB.toString();
        logger.info(info);
        info = "Sum of all elements: " + mathB.summator();
        logger.info(info);
        mathB.splitter(3.0);
        info = "ArrayList after splitter method: " + mathB.toString();
        logger.info(info);
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
