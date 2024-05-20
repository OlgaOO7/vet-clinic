package main.java.com.magicvet.component;

import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

public class ApplicationRunner {
    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                petService.addPet();
                if (petService.petConfirmation) {
                    System.out.println("Adding a pet.");

                    Pet pet = petService.registerNewPet();
                    if (pet != null) {
                        client.setPet(pet);
                        pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                        System.out.println("Pet has been added.");
                    }
                    System.out.println(client);
                } else {
                    System.out.println("Pet has not been added.");
                    System.out.println(client);
                }


            }
        }
    }
}
