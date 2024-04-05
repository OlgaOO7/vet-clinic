package main.java.com.magicvet;

import java.util.Scanner;

public class Main {

    static String PASSWORD = "default";

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        run();
    }

    static void run() {
        boolean accepted = false;

        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = scanner.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }

        System.out.println(accepted ? "Welcome to Magic Vet." : "Application has been blocked.");
    }
}