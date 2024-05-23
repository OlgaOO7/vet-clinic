package main.java.com.magicvet;

import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;


import java.util.Arrays;
import java.util.Comparator;

public class SandboxAge {
    public static void main(String[] args) {
        Pet[] pets = {
                new Cat(Cat.Age.AGE8),
                new Dog(Dog.Age.AGE1),
                new Dog(Dog.Age.AGE5),
                new Cat(Cat.Age.AGE9),
                new Dog(Dog.Age.AGE4),
                new Dog(Dog.Age.AGE2),
                new Dog(Dog.Age.AGE3),
                new Cat(Cat.Age.AGE10),
                new Cat(Cat.Age.AGE6),
                new Cat(Cat.Age.AGE7),
                new Cat(Cat.Age.AGE8),
        };

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getAge().getAgeValue() - o2.getAge().getAgeValue();
            }
        });

        for (Pet pet : pets) {
            System.out.println(pet.getAge());
        }
    }
}
