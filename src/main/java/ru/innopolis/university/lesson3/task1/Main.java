package ru.innopolis.university.lesson3.task1;

public class Main {

    public static void main(String[] args) {
        Number[] numbers = new Number[5];
        numbers[0] = 5;
        numbers[1] = 2;
        numbers[2] = 1;
        numbers[3] = 4;
        numbers[4] = 1;

        MathBox mathB = new MathBox(numbers);
        mathB.toString();
        System.out.println(mathB.summator());
    }
}
