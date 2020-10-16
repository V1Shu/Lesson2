package ru.innopolis.university.lesson5.model;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson5.services.AnimalException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

public class AnimalList {
    private static final Logger logger = Logger.getLogger(String.valueOf(AnimalList.class));

    public final ArrayList<Animal> animalList;

    public AnimalList() {
        this.animalList = new ArrayList<>();
    }

    public void addAnimal(Animal animal) throws AnimalException {
        if (!animalList.contains(animal)) {
            animalList.add(animal);
       } else {
            throw new AnimalException("Animal already in the list");
        }
    }

    public Animal findAnimal(String name) {
        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        logger.info("Animal is not found");
        return null;
    }

    private Animal findAnimalByID(int ID) {
        for (Animal animal : animalList) {
            if ((animal.getID() == ID)) {
                return animal;
            }
        }
        logger.info("Animal is not found");
        return null;
    }

    public void changeAnimalName(int ID, String name) {
        Animal changedAnimal = findAnimalByID(ID);
        if (changedAnimal != null) {
            changedAnimal.setName(name);
        }
    }

    public void changeAnimalOwner(int ID, Person owner) {
        Animal changedAnimal = findAnimalByID(ID);
        if (changedAnimal != null) {
            changedAnimal.setOwner(owner);
        }
    }

    public void changeAnimalWeight(int ID, int weight) {
        Animal changedAnimal = findAnimalByID(ID);
        if (changedAnimal != null) {
            changedAnimal.setWeight(weight);
        }
    }

    public void printAnimalList() {
        for (Animal animal : animalList) {
            logger.info(animal.toString());
        }
    }

    public void printSortAnimalList() {


        for (Animal animal : animalList) {
            logger.info(animal.toString());
        }
    }

    private void sortAnimalList() {
        animalList.sort(Comparator.comparing(Animal::getID));
    }
}
