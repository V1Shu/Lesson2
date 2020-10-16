package ru.innopolis.university.lesson2.task3.sort;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson2.task3.model.Sex;

/**
 * Override directions of sort. All directions sort by bubble
 */
public class InsertionSort implements SortInterface {
    @Override
    public void manFirst(Person[] personArray) {
        for (int i = 1; i < personArray.length; i++) {
            Person current = personArray[i];
            int j = i - 1;
            while(j >= 0 && current.getSex() == Sex.MAN) {
                personArray[j+1] = personArray[j];
                j--;
            }
            personArray[j+1] = current;
        }
    }

    @Override
    public void olderFirst(Person[] personArray) {
        for (int i = 1; i < personArray.length; i++) {
            Person current = personArray[i];
            int j = i - 1;
            while(j >= 0 && current.getAge() > personArray[j].getAge()) {
                personArray[j+1] = personArray[j];
                j--;
            }
            personArray[j+1] = current;
        }
    }

    @Override
    public void alphabet(Person[] personArray) {
        for (int i = 1; i < personArray.length; i++) {
            Person current = personArray[i];
            int j = i - 1;
            while (j >= 0 && current.compareTo(personArray[j]) < 0) {
                personArray[j+1] = personArray[j];
                j--;
            }
            personArray[j+1] = current;
        }
    }
}
