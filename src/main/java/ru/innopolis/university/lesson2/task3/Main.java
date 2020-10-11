package ru.innopolis.university.lesson2.task3;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson2.task3.model.SortType;
import ru.innopolis.university.lesson2.task3.service.serviceMethods;
import ru.innopolis.university.lesson2.task3.sort.BubbleSort;
import ru.innopolis.university.lesson2.task3.sort.InsertionSort;
import ru.innopolis.university.lesson2.task3.sort.SortInterface;

import java.util.Scanner;

/**
 * @author Shulepov Vadim
 */
public class Main {

    /**
     * Generate Array of Person objects, ask user how to sort it and print result of sort
     * @param args
     */
    public static void main(String[] args) {
        Person[] personArray = new Person[10000];
        serviceMethods.fillArrayOfPerson(personArray);

        printResult(personArray);
        printInstructions();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        while (select != 0) {
            switch (select) {
                case 1: callSort(personArray.clone(), SortType.MANFIRST, new BubbleSort()); break;
                case 2: callSort(personArray.clone(), SortType.MANFIRST, new InsertionSort()); break;
                case 3: callSort(personArray.clone(), SortType.OLDERFIRST, new BubbleSort()); break;
                case 4: callSort(personArray.clone(), SortType.OLDERFIRST, new InsertionSort()); break;
                case 5: callSort(personArray.clone(), SortType.ALPHABET, new BubbleSort()); break;
                case 6: callSort(personArray.clone(), SortType.ALPHABET, new InsertionSort()); break;
                default:
                    System.out.println("Incorrect number");
                    break;
            }
            select = scanner.nextInt();
        }
    }

    /**
     * print instructions at console
     */
    private static void printInstructions() {
        System.out.println("\nType number of sort :");
        System.out.println("Man first : \n1  Bubble sort \n2  Insertion sort");
        System.out.println("Older first : \n3  Bubble sort \n4  Insertion sort");
        System.out.println("Alphabet : \n5  Bubble sort \n6  Insertion sort");
        System.out.println("\n0 For Exit");
    }

    /**
     * Call chosen type and direction of sort
     * @param array Array of Person objects, needed to sort
     * @param type Direction of sort
     * @param sort Type of sort
     */
    private static void callSort(Person[] array, SortType type, SortInterface sort) {
        long startTime = System.nanoTime();
        switch (type) {
            case MANFIRST: sort.manFirst(array); break;
            case OLDERFIRST: sort.olderFirst(array); break;
            case ALPHABET: sort.alphabet(array); break;
        }
        long estimatedTime = System.nanoTime() - startTime;
        printResult(array);
        System.out.println("Estimated time: " + estimatedTime);
    }

    /**
     * Print elements of array
     * @param array Array of Person objects, needed to print
     */
    private static void printResult(Person[] array) {
        System.out.println("-------------------------RESULT---------------------------");
        for (Person person : array) {
            System.out.println(person.toString());
        }
    }
}
