package ru.innopolis.university.Lesson2.Task3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person[] personArray = new Person[3];
        Person.FillArray(personArray);
        personArray[0].name = "aab";
        personArray[1].name = "bac";
        personArray[2].name = "abc";

        for (Person person : personArray) {
            System.out.println(person.name + "_____" + person.age + "____" + person.sex);
        }

        System.out.println("----------------------------------------------");
        System.out.println(personArray[0].compareTo(personArray[1]));
        /*InsertionSort bubbleSort = new InsertionSort();

        bubbleSort.Alphabet(personArray);
        for (Person person : personArray) {
            System.out.println(person.name + "_____" + person.age + "____" + person.sex);
        }*/
    }
}
