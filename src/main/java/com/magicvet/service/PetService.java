package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.model.Dog;

import java.util.Optional;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";
    public boolean petConfirmation;

    public void askAddPet() {
        petConfirmation = false;
        System.out.print("Do you want to add a pet? (yes / no): ");
        String addingPetConfirmation = Main.SCANNER.nextLine();

        if(addingPetConfirmation.equals("yes")) {
            petConfirmation = true;
        }
    }

    public Optional<Pet> registerNewPet() {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if(DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }

        return Optional.ofNullable(pet);
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog(Dog.Size.M);
        pet.setType(type);

        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        System.out.print("Sex (male / female): ");
        Pet.Sex sex;
        String sexInput = Main.SCANNER.nextLine().toUpperCase().replace(" ", "_");
        try {
            sex = Pet.Sex.valueOf(sexInput);
        } catch (IllegalArgumentException e) {
            sex = Pet.Sex.UNKNOWN;
            System.out.println("Unknown to parse value '" + sexInput
                    + "'. Using default value: " + Pet.Sex.UNKNOWN);
        }
        pet.setSex(sex);

        if (type.equals((DOG_TYPE))) {
            System.out.print("Size (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog) pet).setSize(Dog.Size.fromString(size));
        }

        System.out.print("Health state (healthy / recovery / critical / chronic illness / minor illness / serious illness): ");
        Pet.HealthState healthState;
        String healthStateInput = Main.SCANNER.nextLine().toUpperCase().replace(" ", "_");

        try {
            healthState = Pet.HealthState.valueOf(healthStateInput);
        } catch (IllegalArgumentException e) {
            healthState = Pet.HealthState.UNKNOWN;
            System.out.println("Unknown to parse value '" + healthStateInput
                    + "'. Using default value: " + Pet.HealthState.UNKNOWN);
        }
        pet.setHealthState(healthState);
        return pet;
    }
}
