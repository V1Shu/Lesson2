package ru.innopolis.university.Lesson2.Task3;

import java.util.Random;

public class Person implements Comparable {

    private int age;
    private String name;
    private Sex sex;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Person (int age, String name, Sex sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public static void FillArray(Person[] PersonArray) {
        for (int count = 0; count < PersonArray.length; count++) {
            PersonArray[count] = new Person(RandomAge(), RandomName(), RandomSex());
        }
    }

    private static Sex RandomSex() {
        Random random = new Random();
        return random.nextBoolean() ? Sex.MAN : Sex.WOMAN;
    }

    private static String RandomName() {
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

    private static int RandomAge() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    public int compareTo(Object o) {
        Person firstPerson = this;
        Person secondPerson = (Person) o;

        String firstPersonName = firstPerson.name;
        String secondPersonName = secondPerson.name;

        return firstPersonName.compareToIgnoreCase(secondPersonName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name= " + name +
                " , age= '" + age + '\'' +
                " , sex= " + sex +
                '}';
    }
}
