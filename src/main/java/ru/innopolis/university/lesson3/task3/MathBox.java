package ru.innopolis.university.lesson3.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Class allows user to work with array of numbers
 * @author v.shulepov
 */
public class MathBox extends ObjectBox {
    private static final Logger logger = Logger.getLogger(String.valueOf(ru.innopolis.university.lesson3.task3.MathBox.class));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBoxTask3 = (MathBox) o;
        return Objects.equals(list, mathBoxTask3.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public boolean addObject(Object obj) throws NotNumberException {
        if (obj instanceof Number) {
            list.add((Number) obj);
            return true;
        }
        throw new NotNumberException("Getting object must be Number");
    }

    @Override
    public String dump() {
        StringBuilder output = new StringBuilder();
        for (Number number : list) {
            output.append(number.toString()).append("  ");
        }
        return output.toString();
    }
}

class NotNumberException extends Exception {
    public NotNumberException(String message) {
        super(message);
    }
}
