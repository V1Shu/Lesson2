package ru.innopolis.university.lesson5.model;

import ru.innopolis.university.lesson2.task3.model.Person;

import java.util.Objects;
import java.util.Random;

public class Animal implements Comparable<Animal> {

    private int ID;
    private String name = "Unnamed";
    private Person owner;
    private int weight = 1;

    private Random random = new Random();

    public Animal() {
        this.ID = random.nextInt(99);
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

    @Override
    public int compareTo(Animal animal) {
        if (this.getOwner().compareTo(animal.getOwner()) == 0) {
            if (this.getName().compareToIgnoreCase(animal.getName()) == 0) {
                if (this.getWeight() == animal.getWeight()) {
                    return 0;
                } else if (this.getWeight() > animal.getWeight()) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.getName().compareToIgnoreCase(animal.getName()) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.getOwner().compareTo(animal.getOwner()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
