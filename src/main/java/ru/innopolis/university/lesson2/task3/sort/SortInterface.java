package ru.innopolis.university.lesson2.task3.sort;

import ru.innopolis.university.lesson2.task3.model.Person;

/**
 * Contains direction of sort
 */
public interface SortInterface {

    /**
     * Person with sex "Man" will be first
     * @param personArray input Array of Person objects
     */
    void manFirst(Person[] personArray);

    /**
     * Oldest Person first (by age)
     * @param personArray input Array of Person objects
     */
    void olderFirst(Person[] personArray);

    /**
     * Alphabet (by name)
     * @param personArray input Array of Person objects
     */
    void alphabet(Person[] personArray);
}
