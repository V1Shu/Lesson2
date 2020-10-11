package ru.innopolis.university.lesson2.task3.service;

import ru.innopolis.university.lesson2.task3.model.Person;

/**
 * Contain common service methods
 */
public class ServiceMethods {

    /**
     * Fill Array of Person objects by Person with randomize age, name and sex
     * @param personArray
     */
    public static void fillArrayOfPerson(Person[] personArray) {
        for (int count = 0; count < personArray.length; count++) {
            personArray[count] = new Person();
        }
    }
}
