package ru.innopolis.university.lesson2.task2;

import java.util.Scanner;
import java.util.Random;

/**
 * Generate some count of integer random numbers. If Math.sqrt ^ 2 = this counter, than print this counter
 * @author Shulepov Vadim
 */
public class RandomTask {

    public static void main(String[] args) {

        Random random = new Random();
        int countOfNumbers = getCountOfNumbers();

        for (int counter = 0; counter < countOfNumbers; counter++) {
            int  randomNumber = random.nextInt(100);
            double numberRoot = Math.sqrt(randomNumber);
            int intForNumberRoot = (int) numberRoot;
            if (intForNumberRoot * intForNumberRoot == counter) {
                System.out.println(counter);
            }
        }
    }

    /**
     * Ask user - how many numbers does he need to generate
     * If user type negative number, will throw
     * @exception ArithmeticException
     * @return
     */
    static int getCountOfNumbers() {
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
