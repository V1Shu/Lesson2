package ru.innopolis.university.lesson10;

public interface Worker {
    default void doWork() {
        for (int count =0; count < 3; count++){
            System.out.println("I am Worker");
            System.out.println("and I'm working");
        }
    };
}
