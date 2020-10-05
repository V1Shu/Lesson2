package ru.innopolis.university.Lesson2.Task3;

public class Main {

    public static void main(String[] args) {
        Person[] personArray = new Person[10];
        Person.FillArray(personArray);

        for (Person person : personArray) {
            System.out.println(person.name + "_____" + person.age + "____" + person.sex);
        }

        System.out.println("----------------------------------------------");

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.ManFirst(personArray);

        for (Person person : personArray) {
            System.out.println(person.name + "_____" + person.age + "____" + person.sex);
        }
    }
}
