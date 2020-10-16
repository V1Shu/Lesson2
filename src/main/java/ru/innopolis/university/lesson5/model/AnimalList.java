package ru.innopolis.university.lesson5.model;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson5.services.AnimalException;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AnimalList {
    private static final Logger logger = Logger.getLogger(String.valueOf(AnimalList.class));

    public final ArrayList<Animal> animalList;

    public AnimalList() {
        this.animalList = new ArrayList<>();
    }

    public void addAnimal(Animal animal) throws AnimalException {
        if (animalList.contains(animal)) {
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

    public void changeAnimal(int ID, String name, Person owner, int weight) {

    }
}
