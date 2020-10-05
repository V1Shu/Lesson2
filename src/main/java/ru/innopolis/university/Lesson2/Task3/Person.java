package ru.innopolis.university.Lesson2.Task3;

import java.util.Comparator;
import java.util.Random;

public class Person implements Comparable {

    int age;
    String name;
    Sex sex;

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

        char[] firstPersonName = firstPerson.name.toCharArray();
        char[] secondPersonName = secondPerson.name.toCharArray();

        int minLength = Math.min(firstPersonName.length, secondPersonName.length);

        for (int counter = 0; counter < minLength; counter++) {
            if (firstPersonName[counter] < secondPersonName[counter]) {
                return 1;
            }
        }
        return -1;
    }
}
