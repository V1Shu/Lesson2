package ru.innopolis.university.lesson13.task1;

import java.util.ArrayList;
import java.util.List;

public class Heap_OutOfMemory {
    private static List objects = new ArrayList();

    public static void main(String[] args){
        while (true) {
            createObjects();
            removeObjects();
        }
    }

    public static void createObjects() {
        System.out.println("Creating objects...");
        for (int i = 0; i < 3; i++) {
            objects.add(new byte[10*1024*1024]);
        }
    }

    public static void removeObjects() {
        System.out.println("Removing objects...");
        int start = objects.size() - 1;
        int end = start - 2;
        for (int i = start; ((i >= 0) && (i > end)); i--) {
            objects.remove(i);
        }
    }
}
