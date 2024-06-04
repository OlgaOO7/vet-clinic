package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.model.Dog;

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

    public Pet registerNewPet() {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if(DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }

        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog(Dog.Size.M);
        pet.setType(type);

        System.out.print("Age: ");
        int age = Integer.parseInt(Main.SCANNER.nextLine());
//        pet.setAge(Pet.Age.valueOf(String.valueOf(age)));
        pet.setAge(Pet.Age.fromValue(age));

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        System.out.print("Sex (male / female): ");
        pet.setSex(Main.SCANNER.nextLine());

        if (type.equals((DOG_TYPE))) {
            System.out.print("Size (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog) pet).setSize(Dog.Size.valueOf(size));
        }

        System.out.print("Health state (healthy / recovery / critical / chronic illness / minor illness / serious illness): ");
        String healthState = Main.SCANNER.nextLine().toUpperCase().replace(" ", "_");
        pet.setHealthState(Pet.HealthState.valueOf(healthState));

        return pet;
    }



}
