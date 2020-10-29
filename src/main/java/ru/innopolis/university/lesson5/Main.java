package ru.innopolis.university.lesson5;

import ru.innopolis.university.lesson2.task3.model.Person;
import ru.innopolis.university.lesson5.model.Animal;
import ru.innopolis.university.lesson5.model.AnimalList;
import ru.innopolis.university.lesson5.services.AnimalException;

import java.util.logging.Logger;

import static ru.innopolis.university.lesson5.services.ServiceMethods.randomName;

/**
 * Test class AnimalList
 * @author v.shulepov
 */
public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws AnimalException {
        AnimalList animalList = new AnimalList();
        //fill list by new Animals, have chance to trow AnimalException
        for (int i = 0; i < 10; i++) {
            animalList.addAnimal(new Animal(randomName()));
        }

        //print list of animals before and after sort
        animalList.printAnimalList();
        logger.info("==========================SORTED LIST========================");
        animalList.printSortAnimalList();

        testChangeAnimal(animalList);
        String info = "Animal with changed name, owner and Weight : " + animalList.findAnimalByName("Ivan");
        logger.info(info);
    }

    /**
     * change name, owner and weight of first element of animalList
     * @param animalList list of Animal objects
     */
    private static void testChangeAnimal(AnimalList animalList) {
        animalList.changeAnimalName(animalList.getAnimalHashMap().entrySet().iterator().next().getKey(),"Ivan");
        animalList.changeAnimalOwner(animalList.getAnimalHashMap().entrySet().iterator().next().getKey(), new Person());
        animalList.changeAnimalWeight(animalList.getAnimalHashMap().entrySet().iterator().next().getKey(), 120);
    }


}
