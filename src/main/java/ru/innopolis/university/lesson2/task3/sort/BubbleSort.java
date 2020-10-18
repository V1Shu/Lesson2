package ru.innopolis.university.lesson2.task3.sort;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson2.task3.model.Sex;

/**
 * Override directions of sort. All directions sort by bubble
 */
public class BubbleSort implements SortInterface {

    @Override
    public void manFirst(Person[] personArray) {
        boolean sorted = false;
        Person tempLink;
        int counter = 0;
        while(!sorted && counter < personArray.length) {
            sorted = true;
            for (int i = 0; i < personArray.length - 1; i++) {
                if (personArray[i].getSex() == Sex.WOMAN) {
                    tempLink = personArray[i];
                    personArray[i] = personArray[i+1];
                    personArray[i+1] = tempLink;
                    sorted = false;
                }
            }
            counter++;
        }
    }

    @Override
    public void olderFirst(Person[] personArray) {
        boolean sorted = false;
        Person tempLink;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < personArray.length - 1; i++) {
                if (personArray[i].getAge() < personArray[i + 1].getAge()) {
                    tempLink = personArray[i];
                    personArray[i] = personArray[i+1];
                    personArray[i+1] = tempLink;
                    sorted = false;
                }
            }
        }
    }

    @Override
    public void alphabet(Person[] personArray) {
        boolean sorted = false;
        Person tempLink;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < personArray.length - 1; i++) {
                if (personArray[i].compareTo(personArray[i + 1]) > 0) {
                    tempLink = personArray[i];
                    personArray[i] = personArray[i+1];
                    personArray[i+1] = tempLink;
                    sorted = false;
                }
            }
        }
    }
}
