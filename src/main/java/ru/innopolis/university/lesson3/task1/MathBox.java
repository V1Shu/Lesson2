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
        for (int counter = list.size() - 1; counter > 0; counter--)
            if (list.get(counter) == list.get(counter - 1)) {
                list.remove(counter);
            }
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
    public Number splitter() {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public void printList() {

    }

    @Override
    public String toString() {
        String output = "";
        for (Number number : list) {
            output += " " + number.toString();
        }
        return output;
    }
}
