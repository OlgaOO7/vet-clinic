package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Pet;

import java.util.Comparator;

public class PetAgeComparator implements Comparator<Pet> {

    @Override
    public int compare(Pet pet1, Pet pet2) {
        int age1 = convertAge(pet1.getAge());
        int age2 = convertAge(pet2.getAge());
        return Integer.compare(age1, age2);
    }

    public static int convertAge(String age) {
        return Integer.parseInt(age);
    }
}
