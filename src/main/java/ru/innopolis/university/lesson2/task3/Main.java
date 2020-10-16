package ru.innopolis.university.lesson2.task3;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson2.task3.model.SortType;
import ru.innopolis.university.lesson2.task3.service.ServiceMethods;
import ru.innopolis.university.lesson2.task3.sort.BubbleSort;
import ru.innopolis.university.lesson2.task3.sort.InsertionSort;
import ru.innopolis.university.lesson2.task3.sort.SortInterface;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author Shulepov Vadim
 */
public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));
    /**
     * Generate Array of Person objects, ask user how to sort it and print result of sort
     * @param args input arguments
     */
    public static void main(String[] args) {
        Person[] personArray = new Person[10_000];
        ServiceMethods.fillArrayOfPerson(personArray);

        printResult(personArray);
        printInstructions();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        while (select != 0) {
            switch (select) {
                case 1: callSort(personArray.clone(), SortType.MAN_FIRST, new BubbleSort()); break;
                case 2: callSort(personArray.clone(), SortType.MAN_FIRST, new InsertionSort()); break;
                case 3: callSort(personArray.clone(), SortType.OLDER_FIRST, new BubbleSort()); break;
                case 4: callSort(personArray.clone(), SortType.OLDER_FIRST, new InsertionSort()); break;
                case 5: callSort(personArray.clone(), SortType.ALPHABET, new BubbleSort()); break;
                case 6: callSort(personArray.clone(), SortType.ALPHABET, new InsertionSort()); break;
                default:
                    logger.info("Incorrect number");
                    break;
            }
            select = scanner.nextInt();
        }
    }

    /**
     * print instructions at console
     */
    private static void printInstructions() {
        logger.info("\nType number of sort :");
        logger.info("Man first : \n1  Bubble sort \n2  Insertion sort");
        logger.info("Older first : \n3  Bubble sort \n4  Insertion sort");
        logger.info("Alphabet : \n5  Bubble sort \n6  Insertion sort");
        logger.info("\n0 For Exit");
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
            case MAN_FIRST: sort.manFirst(array); break;
            case OLDER_FIRST: sort.olderFirst(array); break;
            case ALPHABET: sort.alphabet(array); break;
        }
        long estimatedTime = System.nanoTime() - startTime;
        printResult(array);
        String info = "Estimated time: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS)
                + " MilliSeconds";
        logger.info(info);
    }

    /**
     * Print elements of array
     * @param array Array of Person objects, needed to print
     */
    private static void printResult(Person[] array) {
        logger.info("-------------------------RESULT---------------------------");
        for (Person person : array) {
            String info = person.toString();
            logger.info(info);
        }
    }
}