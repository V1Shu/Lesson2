package ru.innopolis.university.lesson5.services;

/**
 * Exceptions of objects Animals and AnimalLists
 * @author v.shulepov
 */
public class AnimalException extends Exception {
    /**
     * throw if Animal object already in animalList
     * @param message showing message
     */
    public AnimalException(String message) {
        super(message);
    }
}
