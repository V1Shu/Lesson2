package ru.innopolis.university.lesson3.task3;

import ru.innopolis.university.lesson3.task2.ObjectBox;

public class Main {
    public static void main(String[] args) throws NotNumberException {

        ObjectBoxTask3 objBox = new ObjectBoxTask3();
        testInput(objBox);

        System.out.println("Input List: " + objBox.dump());
        objBox.deleteObject("string");
        System.out.println("List after delete \"string\": " + objBox.dump());

        Number[] numbers = new Number[8];
        ru.innopolis.university.lesson3.task1.Main.testInput(numbers);

        MathBoxTask3 mathB = new MathBoxTask3(numbers);

        System.out.println("Input ArrayList: " + mathB.dump());
        mathB.deleteObject(5);
        System.out.println("Array after remove element: " + mathB.dump());
        mathB.addObject(954);
        System.out.println("Array after add new number element: " + mathB.dump());
        System.out.println("Sum of all elements: " + mathB.summator());
        mathB.splitter(3.0);
        System.out.println("ArrayList after splitter method: " + mathB.dump());
        mathB.addObject(new String());
    }

    /**
     * Add some objects in array
     * @param objBox ObjectBox needed to fill
     */
    private static void testInput(ObjectBoxTask3 objBox) throws NotNumberException {
        objBox.addObject(5);
        objBox.addObject("string");
        objBox.addObject(new Exception());
    }
}
