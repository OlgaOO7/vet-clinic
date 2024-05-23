package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandboxHealthState {
    public static void main(String[] args) {
        Pet[] pets = {
                new Dog(Dog.HealthState.CRITICAL),
                new Dog(Dog.HealthState.CHRONIC_ILLNESS),
                new Cat(Cat.HealthState.HEALTHY),
                new Cat(Cat.HealthState.SERIOUS_ILLNESS),
                new Dog(Dog.HealthState.RECOVERY),
                new Cat(Cat.HealthState.MINOR_ILLNESS),

        };

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getHealthState().getHealthValue().compareTo(o2.getHealthState().getHealthValue());
            }
        });

        for (Pet pet : pets) {
            System.out.println(pet.getHealthState());
        }
    }
}
