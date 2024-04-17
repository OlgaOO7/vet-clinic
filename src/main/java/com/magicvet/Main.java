package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";

    static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[a-zA-Z]{3,}(-[a-zA-Z]{3,})*$";




    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }

    static boolean auth () {
        boolean accepted = false;

        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }

        System.out.println(accepted ? "Welcome to Magic Vet." : "Application has been blocked.");

        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();

        if (isEmailValid(email)) {
            Client client = buildClient(email);
            if (client != null) {
                System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + email + ")");
            } else {
                System.out.println("Invalid client data.");
            }
        } else {
            System.out.println("Provided email is invalid.");
        }
    }


    static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        System.out.print("Firs name: ");
        String firstName = SCANNER.nextLine();

        if (isNameValid(firstName)) {
            client.firstName = firstName;
        } else {
            System.out.println("First name is invalid");
            return null;
        }

        System.out.print("Last name: ");
        String lastName = SCANNER.nextLine();

        if (isNameValid(lastName)) {
            client.lastName = lastName;
        } else {
            System.out.println("Last name is invalid");
            return null;
        }

        return client;
    }

    private static boolean isNameValid(String name) {
        Pattern patter = Pattern.compile(NAME_PATTERN);
        Matcher matcher = patter.matcher(name);
        return matcher.matches();
    }

    static boolean isEmailValid(String email) {
        Pattern patter = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = patter.matcher(email);
        return matcher.matches();
    }

}