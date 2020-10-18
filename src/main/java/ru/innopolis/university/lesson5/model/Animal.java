package ru.innopolis.university.lesson5.model;

import ru.innopolis.university.lesson2.task3.model.Person;

import java.util.Objects;
import java.util.Random;

/**
 * Class contains information about animal
 * @author v.shulepov
 */
public class Animal {
    /**
     * identifier
     */
    private final int ID;
    private String name = "Unnamed";
    private Person owner;
    private int weight;

    /**
     * Constructor without arg
     */
    public Animal() {

        Random random = new Random();
        this.ID = random.nextInt(99);
        this.owner = new Person();
        this.weight = random.nextInt(30);
    }

    /**
     * Constructor taking name
     * @param name String type
     */
    public Animal(String name) {
        this();
        this.name = name;
    }

    /**
     * Constructor taking name and weight
     * @param name String type
     * @param weight int type
     */
    public Animal(String name, int weight) {
        this(name);
        this.weight = weight;
    }

    public int getID() {return ID;}

    public String getName() {return name;}

    public Person getOwner() { return owner;}

    public int getWeight() {return weight;}

    public void setName(String name) {this.name = name;}

    public void setOwner(Person owner) {this.owner = owner;}

    public void setWeight(int weight) {this.weight = weight;}

    @Override
    public String toString() {
        return "Animal{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", weight=" + weight +
                '}';
    }

    /**
     * Compare Animals by ID
     * @param o Animal object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return ID == animal.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
