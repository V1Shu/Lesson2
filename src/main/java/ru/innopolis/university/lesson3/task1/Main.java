package ru.innopolis.university.lesson3.task1;

public class Main {

    public static void main(String[] args) {
        Number[] numbers = new Number[5];
        numbers[0] = (byte) 5;
        numbers[1] = 2;
        numbers[2] = 1L;
        numbers[3] = 4.2f;
        numbers[4] = 2;

        MathBox mathB = new MathBox(numbers);
        System.out.println(mathB.toString());
        System.out.println(mathB.summator());
        mathB.splitter(3.0);
        System.out.println(mathB.toString());
    }
}
