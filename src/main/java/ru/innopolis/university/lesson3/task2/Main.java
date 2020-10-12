package ru.innopolis.university.lesson3.task2;

/**
 * Test class ObjectBox
 * @author v.shulepov
 */
public class Main {
    public static void main(String[] args) {
        ObjectBox objBox = new ObjectBox();
        testInput(objBox);

        System.out.println("Input List: " + objBox.dump());
        objBox.deleteObject("string");
        System.out.println("List after delete \"string\": " + objBox.dump());
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
