package ru.innopolis.university.lesson5.model;

import java.util.ArrayList;

public class AnimalList {
    public final ArrayList<Animal> animalList;

    public AnimalList() {
        this.animalList = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }
}
