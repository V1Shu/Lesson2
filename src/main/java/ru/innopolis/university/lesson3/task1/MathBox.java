package ru.innopolis.university.lesson3.task1;

import java.util.*;

/**
 * Class allows user to work with array of numbers
 * @author v.shulepov
 */
public class MathBox {

    private List<Number> list;

    /**
     * Constructor with unique checking
     * @param numberArray Array of Numbers
     */
    public MathBox(Number[] numberArray) {
        list = Arrays.asList(numberArray.clone());

    }

    /**
     * @return Sum of all elements
     */
    public Number summator() {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    /**
     * @return
     */
    public void splitter(Number div) {
        if (div.intValue() == 0) {
            System.out.println("div can't be 0");
            throw new ArithmeticException();
        }
        for (int counter = 0; counter < list.size(); counter++) {
            list.set(counter, list.get(counter).doubleValue() / div.doubleValue());
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (Number number : list) {
            output += number.toString() + " ";
        }
        return output;
    }
}
