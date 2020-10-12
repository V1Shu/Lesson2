package ru.innopolis.university.lesson3.task3;

import java.util.ArrayList;

/**
 * Class contains List of Objects
 * @author v.shulepov
 */
public class ObjectBox {

    private ArrayList<Object> objectList;

    /**
     * Constructor
     */
    public ObjectBox() {
        objectList = new ArrayList<>();
    }

    /**
     * Add object in Array
     * @param obj Input object
     * @return true - added, false - not added
     */
    public boolean addObject(Object obj) {
        return objectList.add(obj);
    }

    /**
     * Remove object from Array
     * @param obj object needed to remove
     * @return true - deleted, false - not founded
     */
    public boolean deleteObject(Object obj) {
        if (objectList.contains(obj)) {
            objectList.remove(obj);
            return true;
        }
        return false;
    }

    /**
     * Print elements of Array
     * @return String contain elements
     */
    public String dump() {
        StringBuilder output = new StringBuilder();
        for (Object obj : objectList) {
            output.append(obj.toString()).append("   ");
        }
        return output.toString();
    }
}
