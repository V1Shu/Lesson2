package ru.innopolis.university.lesson3.task3;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(
            ru.innopolis.university.lesson3.task3.MathBox.class));

    public static void main(String[] args) throws NotNumberException {

        ObjectBox objBox = new ObjectBox();
        testInput(objBox);

        String info = "Input List: " + objBox.dump();
        logger.info(info);
        objBox.deleteObject("string");
        info = "List after delete \"string\": " + objBox.dump();
        logger.info(info);

        Number[] numbers = new Number[8];
        ru.innopolis.university.lesson3.task1.Main.testInput(numbers);

        MathBox mathB = new MathBox(numbers);

        info = "Input ArrayList: " + mathB.dump();
        logger.info(info);
        mathB.deleteObject(5);
        info = "Array after remove element: " + mathB.dump();
        logger.info(info);
        mathB.addObject(954);
        info = "Array after add new number element: " + mathB.dump();
        logger.info(info);
        info = "Sum of all elements: " + mathB.summator();
        logger.info(info);
        mathB.splitter(3.0);
        info = "ArrayList after splitter method: " + mathB.dump();
        logger.info(info);
        mathB.addObject(new String());
    }

    /**
     * Add some objects in array
     * @param objBox ObjectBox needed to fill
     */
    private static void testInput(ObjectBox objBox) throws NotNumberException {
        objBox.addObject(5);
        objBox.addObject("string");
        objBox.addObject(new Exception());
    }
}
