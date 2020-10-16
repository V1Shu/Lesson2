package ru.innopolis.university.lesson5.model;

import ru.innopolis.university.lesson2.task3.model.Person;

import java.util.Random;

public class Animal {

    private int ID;
    private String name = "Unnamed";
    private Person owner;
    private int weight = 1;

    private Random random = new Random();

    public Animal() {
        this.ID = random.nextInt();
        this.owner = new Person();
    }

    public Animal(String name) {
        this();
        this.name = name;
    }

    public Animal(String name, int weight) {
        this(name);
        this.weight = weight;
    }

    public int getID() {return ID;}

    public String getName() {return name;}

    public Person getOwner() { return owner;}

    public int getWeight() {return weight;}


}
