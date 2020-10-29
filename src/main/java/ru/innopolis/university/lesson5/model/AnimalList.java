package ru.innopolis.university.lesson5.model;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson5.services.AnimalException;

import java.util.*;
import java.util.logging.Logger;

/**
 * Contain list of Animal objects
 * @author v.shulepov
 */
public class AnimalList {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(AnimalList.class));

    public final Map<Integer ,Animal> animalHashMap;

    /**
     * Constructor
     */
    public AnimalList() {
        this.animalHashMap = new HashMap<>();
    }

    /**
     * Add Animal object to Array, control to uniqueness
     * @param animal Animal object
     * @throws AnimalException If Animal already in ArrayList
     */
    public void addAnimal(Animal animal) throws AnimalException {
        if (!animalHashMap.containsValue(animal)) {
            animalHashMap.put(animal.getID() ,animal);
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
        for (Map.Entry<Integer, Animal> animal : animalHashMap.entrySet()) {
            if (animal.getValue().getName().equals(name)) {
                return animalHashMap.get(animal.getKey());
            }
        }
        LOGGER.info("Animal is not found");
        return null;
    }

    /**
     * Find Animal by ID for change methods
     * @param ID int
     * @return Animal
     */
    private Animal findAnimalByID(int ID) {
        if (animalHashMap.containsKey(ID)) {
            return animalHashMap.get(ID);
        }
        LOGGER.info("Animal is not found");
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
        for (Map.Entry<Integer, Animal> animal : animalHashMap.entrySet()) {
            String info = animal.getValue().toString();
            LOGGER.info(info);
        }
    }

    /**
     * Sort list of Animals and print it
     */
    public void printSortAnimalList() {
        ArrayList<Animal> sortAnimalList = sortAnimalList();
        for (Animal animal : sortAnimalList) {
            String info = animal.toString();
            LOGGER.info(info);
        }
    }

    /**
     * Sort list of Animals first by owner, then by name, then by weight
     */
    private ArrayList<Animal> sortAnimalList() {
        ArrayList<Animal> sortAnimalList = new ArrayList<>(animalHashMap.values());
        sortAnimalList.sort(Comparator.comparing(Animal::getOwner)
                .thenComparing(Animal::getName).thenComparing(Animal::getWeight));
        return sortAnimalList;
    }

    /**
     * Return AnimalList
     * @return AnimalList
     */
    public Map<Integer ,Animal> getAnimalHashMap() {
        return animalHashMap;
    }
}
