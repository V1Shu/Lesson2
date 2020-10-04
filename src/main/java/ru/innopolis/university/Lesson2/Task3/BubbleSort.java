package ru.innopolis.university.Lesson2.Task3;

public class BubbleSort implements SortInterface {

    @Override
    public void ManFirst(Person[] PersonArray) {
        boolean sorted = false;
        Person tempLink;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < PersonArray.length - 1; i++) {
                if (PersonArray[i].sex == Sex.MAN) {
                    tempLink = PersonArray[i];
                    PersonArray[i] = PersonArray[i+1];
                    PersonArray[i+1] = tempLink;
                    sorted = false;
                }
            }
        }
    }

    @Override
    public void OlderFirst(Person[] PersonArray) {
        boolean sorted = false;
        Person tempLink;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < PersonArray.length - 1; i++) {
                if (PersonArray[i].age > PersonArray[i+1].age) {
                    tempLink = PersonArray[i];
                    PersonArray[i] = PersonArray[i+1];
                    PersonArray[i+1] = tempLink;
                    sorted = false;
                }
            }
        }
    }

    @Override
    public void Alphabet(Person[] PersonArray) {
        boolean sorted = false;
        Person tempLink;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < PersonArray.length - 1; i++) {
                for (int nameLength = 0; nameLength < PersonArray[i].name.length(); nameLength++) {
                    if (PersonArray[i].name.toCharArray()[nameLength] > PersonArray[i+1].name.toCharArray()[nameLength]) {
                        tempLink = PersonArray[i];
                        PersonArray[i] = PersonArray[i+1];
                        PersonArray[i+1] = tempLink;
                        sorted = false;
                        break;
                    }
                }
            }
        }
    }
}
