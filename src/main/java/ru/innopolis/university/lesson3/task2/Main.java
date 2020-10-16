package ru.innopolis.university.lesson3.task2;

import ru.innopolis.university.lesson3.task1.MathBox;

import java.util.logging.Logger;

/**
 * Test class ObjectBox
 * @author v.shulepov
 */
public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(MathBox.class));

    public static void main(String[] args) {
        ObjectBox objBox = new ObjectBox();
        testInput(objBox);

        String info = "Input List: " + objBox.dump();
        logger.info(info);
        objBox.deleteObject("string");
        info = "List after delete \"string\": " + objBox.dump();
        logger.info(info);
    }

    /**
     * Add some objects in array
     * @param objBox ObjectBox needed to fill
     */
    private static void testInput(ObjectBox objBox) {
        objBox.addObject(5);
        objBox.addObject("string");
        objBox.addObject(new Exception());
    }
}
