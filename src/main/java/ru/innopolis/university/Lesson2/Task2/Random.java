package ru.innopolis.university.Lesson2.Task2;

import java.util.Scanner;

public class Random {

    public static void main(String[] args) {

        int countOfNumbers = GetCountOfNumbers();

        for (int counter = 0; counter < countOfNumbers; counter++) {
            double randomNumber = Math.random() * 10;
            double numberRoot = Math.sqrt(randomNumber);
            int intForNumberRoot = (int) numberRoot;
            if (intForNumberRoot * intForNumberRoot == counter) {
                System.out.println(counter);
            }
        }
    }

    static int GetCountOfNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type count of numbers");
        int getCount = scanner.nextInt();
        if (getCount >= 0) {
            return getCount;
        } else {
            throw new ArithmeticException("Number can't be negative");
        }
    }
}
