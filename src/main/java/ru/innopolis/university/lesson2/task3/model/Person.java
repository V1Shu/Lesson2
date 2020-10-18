package ru.innopolis.university.lesson2.task3.model;

import java.util.Objects;
import java.util.Random;

/**
 * Person
 */
public class Person implements Comparable<Person> {

    /**
     * age of Person
     */
    private final int age;

    /**
     * name of Person
     */
    private final String name;

    /**
     * sex of Person
     */
    private final Sex sex;

    static Random random = new Random();

    /**
     * age getter
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * sex getter
     * @return enum Sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * constructor with random age, name, sex
     */
    public Person () {
        this.age = randomAge();
        this.name = randomName();
        this.sex = randomSex();
    }

    /**
     * generate random sex {@link Sex}
     * @return enum Sex
     */
    private static Sex randomSex() {
        return random.nextBoolean() ? Sex.MAN : Sex.WOMAN;
    }

    /**
     * generate random name, length = 6
     * @return random string length of 6 char
     */
    private static String randomName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * generate random age (integer between 0 and 100)
     * @return random int from 0 to 100
     */
    private static int randomAge() {

        return random.nextInt(100);
    }

    /**
     * override toString
     * @return string with name, age and sex
     */
    @Override
    public String toString() {
        return "Person{" +
                "name= " + name +
                " , age= '" + age + '\'' +
                " , sex= " + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                sex == person.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, sex);
    }

    /**
     * override compareTo, comparing Persons by name
     * @param o Person object compare with
     * @return result of compare
     */
    @Override
    public int compareTo(Person o) {
        return this.name.compareToIgnoreCase(o.name);
    }
}
