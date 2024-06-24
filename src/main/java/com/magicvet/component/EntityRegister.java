package main.java.com.magicvet.component;
import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityRegister {
    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    private Optional<Client> addClient() {
        Optional<Client> client = clientService.registerNewClient();
        client.ifPresent(this::registerPets);
        return client;
    }
    public void registerClients() {
//        boolean continueAddClients = true;
        List<Client> clients = new ArrayList<>();
        String message = "Do you want to register more clients? (yes/no): ";
        do {
            Optional<Client> client = addClient();
            client.ifPresent(clients::add);
        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = clients.stream()
                .collect(Collectors.groupingBy(Client::getLocation));
        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
//        for(Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
//            String content = "\nLocation: " + clients.getKey()
//                    + "\nClients (" + clients.getValue().size() + "):"
//                    + "\n\t" + clients.getValue();
        clientsByLocation.forEach((location, clients) -> {
            String content = "\nLocation: " + location
                    + "\nClients (" + clients.size() + "):"
                    + "\n\t" + clients;

            System.out.println(content);
        });
    }

    private void registerPets(Client client) {
        String message = "Do you want to add more pets for the current client? (yes/no): ";

        petService.askAddPet();

        if (petService.petConfirmation) {
            do {
                addPet(client);
                System.out.println(client);
            } while (verifyRepeating(message));
        } else {
            System.out.println("Pet has not been added.");
        }
    }

    private void addPet(Client client) {
        System.out.println("Adding a pet.");
        Optional<Pet> pet = petService.registerNewPet();
        pet.ifPresent(p -> {client.addPet(p);
        p.setOwnerName(client.getFirstName() + " " + client.getLastName());
        System.out.println("Pet has been added.");});

//        if (pet != null) {
//            client.addPet(pet);
//            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
//            System.out.println("Pet has been added.");
//        }
    }

    private boolean verifyRepeating(String message) {
        System.out.println(message);

        String answer = Main.SCANNER.nextLine();
        if("yes".equals(answer)) {
            return true;
        } else if ("no".equals(answer)) {
            return false;
        } else {
            System.out.println("Incorrect answer. Please try again");
            return verifyRepeating(message);
        }
    }
}
