package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;

public class SandboxAge {
    public static void main(String[] args) {
        Pet[] pets = {
                new Dog(Dog.age1),
                new Dog(Dog.age5),
                new Dog(Dog.age4),
                new Dog(Dog.age2),
                new Dog(Dog.age3),
                new Cat(Cat.age6),
                new Cat(Cat.age7),
                new Cat(Cat.age8),
                new Cat(Cat.age9),
                new Cat(Cat.age10),
        };

        Arrays.sort(pets, new PetAgeComparator());

        for (Pet pet : pets) {
            System.out.println(pet.getAge());
        }
    }
}
