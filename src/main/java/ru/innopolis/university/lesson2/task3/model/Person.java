package ru.innopolis.university.lesson2.task3.model;

import java.util.Random;

/**
 * Person
 */
public class Person implements Comparable {

    /**
     * age of Person
     */
    private int age;

    /**
     * name of Person
     */
    private String name;

    /**
     * sex of Person
     */
    private Sex sex;

    /**
     * age getter
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * name getter
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * sex getter
     * @return
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
     * @return
     */
    private static Sex randomSex() {
        Random random = new Random();
        return random.nextBoolean() ? Sex.MAN : Sex.WOMAN;
    }

    /**
     * generate random name, length = 6
     * @return
     */
    private static String randomName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /**
     * generate random age (integer between 0 and 100)
     * @return
     */
    private static int randomAge() {
        Random random = new Random();
        return random.nextInt(100);
    }

    /**
     * override compareTo, comparing Persons by name
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Person firstPerson = this;
        Person secondPerson = (Person) o;

        String firstPersonName = firstPerson.name;
        String secondPersonName = secondPerson.name;

        return firstPersonName.compareToIgnoreCase(secondPersonName);
    }

    /**
     * override toString
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "name= " + name +
                " , age= '" + age + '\'' +
                " , sex= " + sex +
                '}';
    }
}
