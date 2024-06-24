package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z]{3,}(-[a-zA-Z]{3,})*$";

    public Optional<Client> registerNewClient() {
        Client client = null;

        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();

        if (isEmailValid(email)) {
            client = buildClient(email);
            if (client != null) {
                System.out.println("New client: " + client.getFirstName() + " " + client.getLastName() + " (" + client.getEmail() + ")");
            } else {
                System.out.println("Invalid client data.");
            }
        } else {
            System.out.println("Provided email is invalid.");
        }
        return Optional.ofNullable(client);
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        System.out.print("Firs name: ");
        String firstName = Main.SCANNER.nextLine();

        if (isNameValid(firstName)) {
            client.setFirstName(firstName);
        } else {
            System.out.println("First name is invalid");
            return null;
        }

        System.out.print("Last name: ");
        String lastName = Main.SCANNER.nextLine();

        if (isNameValid(lastName)) {
            client.setLastName(lastName);
        } else {
            System.out.println("Last name is invalid");
            return null;
        }

        System.out.print("Location: ");
        Client.Location location;
        String locationInput = Main.SCANNER.nextLine();
        try {
            location = Client.Location.valueOf(locationInput);
        } catch (IllegalArgumentException e) {
            location = Client.Location.UNKNOWN;
            System.out.println("Unknown to parse value '" + locationInput
                    + "'. Using default value: " + Client.Location.UNKNOWN);
        }

        client.setLocation(location);

        return client;
    }

    private static boolean isNameValid(String name) {
        Pattern patter = Pattern.compile(NAME_PATTERN);
        Matcher matcher = patter.matcher(name);
        return matcher.matches();
    }

    private static boolean isEmailValid(String email) {
        Pattern patter = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = patter.matcher(email);
        return matcher.matches();
    }
}
