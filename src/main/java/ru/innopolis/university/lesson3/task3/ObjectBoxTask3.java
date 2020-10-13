package ru.innopolis.university.lesson3.task3;

import java.util.ArrayList;

/**
 * Class contains List of Objects
 * @author v.shulepov
 */
public class ObjectBoxTask3 {

    protected ArrayList<Object> objectList;

    /**
     * Constructor
     */
    public ObjectBoxTask3() {
        objectList = new ArrayList<>();
    }

    /**
     * Add object in Array
     * @param obj Input object
     * @return true - added, false - not added
     */
    public boolean addObject(Object obj) throws NotNumberException {
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
