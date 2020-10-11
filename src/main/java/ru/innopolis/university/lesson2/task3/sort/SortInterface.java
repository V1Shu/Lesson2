package ru.innopolis.university.lesson2.task3.sort;

import ru.innopolis.university.lesson2.task3.model.Person;

/**
 * Contains direction of sort
 */
public interface SortInterface {

    /**
     * Person with sex "Man" will be first
     * @param PersonArray
     */
    void manFirst(Person[] PersonArray);

    /**
     * Oldest Person first (by age)
     * @param PersonArray
     */
    void olderFirst(Person[] PersonArray);

    /**
     * Alphabet (by name)
     * @param PersonArray
     */
    void alphabet(Person[] PersonArray);
}
