package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBoxSex {
    public static void main(String[] args) {
        Pet[] pets = {
                new Dog(Dog.Sex.MALE),
                new Dog(Dog.Sex.FEMALE),
                new Cat(Cat.Sex.MALE),
                new Cat(Cat.Sex.FEMALE),
        };

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getSex().getSexValue().compareTo(o2.getSex().getSexValue());
            }
        });

        for (Pet pet : pets) {
            System.out.println(pet.getSex());
        }
    }
}
