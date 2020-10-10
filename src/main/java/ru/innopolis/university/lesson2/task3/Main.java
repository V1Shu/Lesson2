package ru.innopolis.university.Lesson2.Task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person[] personArray = new Person[10];
        Person.FillArray(personArray);

        PrintResult(personArray);
        PrintInstructions();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        while (select != 0) {
            switch (select) {
                case 1: CallBubbleSort(personArray.clone(), SortType.MANFIRST); break;
                case 2: CallInsertionSort(personArray.clone(), SortType.MANFIRST); break;
                case 3: CallBubbleSort(personArray.clone(), SortType.OLDERFIRST); break;
                case 4: CallInsertionSort(personArray.clone(), SortType.OLDERFIRST); break;
                case 5: CallBubbleSort(personArray.clone(), SortType.ALPHABET); break;
                case 6: CallInsertionSort(personArray.clone(), SortType.ALPHABET); break;
                default:
                    System.out.println("Incorrect number");
                    break;
            }
            select = scanner.nextInt();
        }
    }

    private static void PrintInstructions() {
        System.out.println("\nType number of sort :");
        System.out.println("Man first : \n1  Bubble sort \n2  Insertion sort");
        System.out.println("Older first : \n3  Bubble sort \n4  Insertion sort");
        System.out.println("Alphabet : \n5  Bubble sort \n6  Insertion sort");
        System.out.println("\n0 For Exit");
    }

    private static void CallBubbleSort(Person[] array, SortType type) {
        BubbleSort sort = new BubbleSort();
        long startTime = System.nanoTime();
        switch (type) {
            case MANFIRST: sort.ManFirst(array); break;
            case OLDERFIRST: sort.OlderFirst(array); break;
            case ALPHABET: sort.Alphabet(array); break;
        }
        long estimatedTime = System.nanoTime() - startTime;
        PrintResult(array);
        System.out.println("Estimated time: " + estimatedTime);
    }

    private static void CallInsertionSort(Person[] array, SortType type) {
        InsertionSort sort = new InsertionSort();
        long startTime = System.nanoTime();
        switch (type) {
            case MANFIRST: sort.ManFirst(array); break;
            case OLDERFIRST: sort.OlderFirst(array); break;
            case ALPHABET: sort.Alphabet(array); break;
        }
        long estimatedTime = System.nanoTime() - startTime;
        PrintResult(array);
        System.out.println("Estimated time: " + estimatedTime);
    }

    private static void PrintResult(Person[] array) {
        System.out.println("-------------------------RESULT---------------------------");
        for (Person person : array) {
            System.out.println(person.toString());
        }
    }
}
