package ru.innopolis.university.Lesson2.Task3;

import java.util.Arrays;
import java.util.Collections;

public class InsertionSort implements SortInterface{
    @Override
    public void ManFirst(Person[] PersonArray) {
        for (int i = 1; i < PersonArray.length; i++) {
            Person current = PersonArray[i];
            int j = i - 1;
            while(j >= 0 && current.sex == Sex.MAN) {
                PersonArray[j+1] = PersonArray[j];
                j--;
            }
            PersonArray[j+1] = current;
        }
    }

    @Override
    public void OlderFirst(Person[] PersonArray) {
        for (int i = 1; i < PersonArray.length; i++) {
            Person current = PersonArray[i];
            int j = i - 1;
            while(j >= 0 && current.age > PersonArray[j].age) {
                PersonArray[j+1] = PersonArray[j];
                j--;
            }
            PersonArray[j+1] = current;
        }
    }

    @Override
    public void Alphabet(Person[] PersonArray) {
        for (int i = 0; i < PersonArray.length - 1; i++) {
            Person current = PersonArray[i];
            Person next = PersonArray[i + 1];
            int j = i - 1;
            while (j >= 0 && current.compareTo(next) > 0) {
                PersonArray[j+1] = PersonArray[j];
                j--;
            }
            PersonArray[j+1] = current;
        }
    }
}
