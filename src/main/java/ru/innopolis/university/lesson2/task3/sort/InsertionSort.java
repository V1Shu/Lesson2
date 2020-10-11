package ru.innopolis.university.lesson2.task3.sort;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson2.task3.model.Sex;

/**
 * Override directions of sort. All directions sort by bubble
 */
public class InsertionSort implements SortInterface {
    @Override
    public void manFirst(Person[] PersonArray) {
        for (int i = 1; i < PersonArray.length; i++) {
            Person current = PersonArray[i];
            int j = i - 1;
            while(j >= 0 && current.getSex() == Sex.MAN) {
                PersonArray[j+1] = PersonArray[j];
                j--;
            }
            PersonArray[j+1] = current;
        }
    }

    @Override
    public void olderFirst(Person[] PersonArray) {
        for (int i = 1; i < PersonArray.length; i++) {
            Person current = PersonArray[i];
            int j = i - 1;
            while(j >= 0 && current.getAge() > PersonArray[j].getAge()) {
                PersonArray[j+1] = PersonArray[j];
                j--;
            }
            PersonArray[j+1] = current;
        }
    }

    @Override
    public void alphabet(Person[] PersonArray) {
        for (int i = 1; i < PersonArray.length; i++) {
            Person current = PersonArray[i];
            int j = i - 1;
            while (j >= 0 && current.compareTo(PersonArray[j]) < 0) {
                PersonArray[j+1] = PersonArray[j];
                j--;
            }
            PersonArray[j+1] = current;
        }
    }
}
