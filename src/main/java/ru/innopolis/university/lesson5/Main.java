package ru.innopolis.university.lesson5;

import ru.innopolis.university.lesson5.model.Animal;
import ru.innopolis.university.lesson5.model.AnimalList;
import ru.innopolis.university.lesson5.services.AnimalException;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws AnimalException {
        AnimalList animalList = new AnimalList();
        for (int i = 0; i < 10; i++) {
            animalList.addAnimal(new Animal());
        }
        animalList.printAnimalList();
        animalList.changeAnimalName(5,"Ivan");
        animalList.changeAnimalName(6,"Ivan");
        animalList.changeAnimalName(7,"Ivan");
        animalList.changeAnimalName(8,"Ivan");
        animalList.changeAnimalName(9,"Ivan");
        logger.info(animalList.findAnimal("Ivan").toString());
    }
}
