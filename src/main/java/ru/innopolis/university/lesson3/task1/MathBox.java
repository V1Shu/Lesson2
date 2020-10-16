package ru.innopolis.university.lesson3.task1;

import java.util.*;
import java.util.logging.Logger;

/**
 * Class allows user to work with array of numbers
 * @author v.shulepov
 */
public class MathBox {
    private static final Logger logger = Logger.getLogger(String.valueOf(MathBox.class));
    private final ArrayList<Number> list;

    /**
     * Constructor with unique checking
     * @param numberArray Array of Numbers
     */
    public MathBox(Number[] numberArray) {
        list = new ArrayList<>();
        Collections.addAll(list, numberArray);
        for(int counter = list.size() - 1; counter > 0; counter--){
            if (list.indexOf(list.get(counter)) != list.lastIndexOf(list.get(counter))) {
                list.remove(counter);
            }
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
     * Division every element by input number
     */
    public void splitter(Number div) {
        if (div.intValue() == 0) {
            logger.info("div can't be 0");
            throw new ArithmeticException();
        }
        for (int counter = 0; counter < list.size(); counter++) {
            list.set(counter, list.get(counter).doubleValue() / div.doubleValue());
        }
    }

    /**
     * Remove element from ArrayList, if it's find
     * @param deletedNumber Type Integer
     */
    public void removeElement(Integer deletedNumber) {
        list.remove(deletedNumber);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Number number : list) {
            output.append(number.toString()).append("  ");
        }
        return output.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(list, mathBox.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
