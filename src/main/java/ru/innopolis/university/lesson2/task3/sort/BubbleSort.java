package ru.innopolis.university.lesson2.task3.sort;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson2.task3.model.Sex;

/**
 * Override directions of sort. All directions sort by bubble
 */
public class BubbleSort implements SortInterface {

    @Override
    public void manFirst(Person[] PersonArray) {
        boolean sorted = false;
        Person tempLink;
        int counter = 0;
        while(!sorted && counter < PersonArray.length) {
            sorted = true;
            for (int i = 0; i < PersonArray.length - 1; i++) {
                if (PersonArray[i].getSex() == Sex.WOMAN) {
                    tempLink = PersonArray[i];
                    PersonArray[i] = PersonArray[i+1];
                    PersonArray[i+1] = tempLink;
                    sorted = false;
                }
            }
            counter++;
        }
    }

    @Override
    public void olderFirst(Person[] PersonArray) {
        boolean sorted = false;
        Person tempLink;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < PersonArray.length - 1; i++) {
                if (PersonArray[i].getAge() < PersonArray[i + 1].getAge()) {
                    tempLink = PersonArray[i];
                    PersonArray[i] = PersonArray[i+1];
                    PersonArray[i+1] = tempLink;
                    sorted = false;
                }
            }
        }
    }

    @Override
    public void alphabet(Person[] PersonArray) {
        boolean sorted = false;
        Person tempLink;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < PersonArray.length - 1; i++) {
                if (PersonArray[i].compareTo(PersonArray[i + 1]) > 0) {
                    tempLink = PersonArray[i];
                    PersonArray[i] = PersonArray[i+1];
                    PersonArray[i+1] = tempLink;
                    sorted = false;
                }
            }
        }
    }
}
