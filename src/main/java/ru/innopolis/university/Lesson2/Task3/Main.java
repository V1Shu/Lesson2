package ru.innopolis.university.Lesson2.Task3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person[] personArray = new Person[100];
        Person.FillArray(personArray);

        for (Person person : personArray) {
            System.out.println(person.name + "_____" + person.age + "____" + person.sex);
        }

        System.out.println("----------------------------------------------");

        InsertionSort bubbleSort = new InsertionSort();
        bubbleSort.Alphabet(personArray);

        for (Person person : personArray) {
            System.out.println(person.name + "_____" + person.age + "____" + person.sex);
        }
    }
}
