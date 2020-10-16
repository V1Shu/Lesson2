package ru.innopolis.university.lesson2.task1.helloworld;

import ru.innopolis.university.lesson2.task1.errors.ErrorExamples;
import ru.innopolis.university.lesson2.task1.errors.MyException;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Randomly print "Hello World" or call one of Exceptions: ArrayOutOfBounds, NullPointer, Arithmetical
 * @author Shulepov Vadim
 */
public class HelloWorld {
    private static final Logger logger = Logger.getLogger(String.valueOf(HelloWorld.class));

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
                logger.info("Hello World");
                break;
        }
    }
}
