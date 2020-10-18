package ru.innopolis.university.lesson5.model;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson5.services.AnimalException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Contain list of Animal objects
 * @author v.shulepov
 */
public class AnimalList {
    private static final Logger logger = Logger.getLogger(String.valueOf(AnimalList.class));

    public final List<Animal> animalArrayList;

    /**
     * Constructor
     */
    public AnimalList() {
        this.animalArrayList = new ArrayList<>();
    }

    /**
     * Add Animal object to Array, control to uniqueness
     * @param animal Animal object
     * @throws AnimalException If Animal already in ArrayList
     */
    public void addAnimal(Animal animal) throws AnimalException {
        if (!animalArrayList.contains(animal)) {
            animalArrayList.add(animal);
       } else {
            throw new AnimalException("Animal already in the list");
        }
    }

    /**
     * Find Animal object in Array
     * @param name String contains name of Animal
     * @return Found Animal or null
     */
    public Animal findAnimalByName(String name) {
        for (Animal animal : animalArrayList) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        logger.info("Animal is not found");
        return null;
    }

    /**
     * Find Animal by ID for change methods
     * @param ID int
     * @return Animal
     */
    private Animal findAnimalByID(int ID) {
        for (Animal animal : animalArrayList) {
            if ((animal.getID() == ID)) {
                return animal;
            }
        }
        logger.info("Animal is not found");
        return null;
    }

    /**
     * Change name of one Animal
     * @param ID int
     * @param name String, new name
     */
    public void changeAnimalName(int ID, String name) {
        Animal changedAnimal = findAnimalByID(ID);
        if (changedAnimal != null) {
            changedAnimal.setName(name);
        }
    }

    /**
     * Change owner of one Animal
     * @param ID int
     * @param owner Person
     */
    public void changeAnimalOwner(int ID, Person owner) {
        Animal changedAnimal = findAnimalByID(ID);
        if (changedAnimal != null) {
            changedAnimal.setOwner(owner);
        }
    }

    /**
     * Change weight of one Animal
     * @param ID int
     * @param weight int, new weight
     */
    public void changeAnimalWeight(int ID, int weight) {
        Animal changedAnimal = findAnimalByID(ID);
        if (changedAnimal != null) {
            changedAnimal.setWeight(weight);
        }
    }

    /**
     * Print Animals, contains in list
     */
    public void printAnimalList() {
        for (Animal animal : animalArrayList) {
            String info = animal.toString();
            logger.info(info);
        }
    }

    /**
     * Sort list of Animals and print it
     */
    public void printSortAnimalList() {
        sortAnimalList();
        printAnimalList();
    }

    /**
     * Sort list of Animals first by owner, then by name, then by weight
     */
    private void sortAnimalList() {
        animalArrayList.sort(Comparator.comparing(Animal::getOwner)
                .thenComparing(Animal::getName).thenComparing(Animal::getWeight));
    }

    /**
     * Return AnimalList
     * @return AnimalList
     */
    public List<Animal> getAnimalArrayList() {
        return animalArrayList;
    }
}
