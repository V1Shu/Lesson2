package ru.innopolis.university.lesson2.task1.helloworld;

import ru.innopolis.university.lesson2.task1.errors.ErrorExamples;
import ru.innopolis.university.lesson2.task1.errors.MyException;

import java.util.Random;

/**
 * Randomly print "Hello World" or call one of Exceptions: ArrayOutOfBounds, NullPointer, Arithmetical
 * @author Shulepov Vadim
 */
public class HelloWorld {
    public static void main(String[] args) throws MyException {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 1:
                ErrorExamples.arrayOutOfBounds();
                break;
            case 2:
                ErrorExamples.nullPointerException(null);
                break;
            case 3:
                ErrorExamples.throwException();
                break;
            default:
                System.out.println("Hello World");
                break;
        }
    }
}
