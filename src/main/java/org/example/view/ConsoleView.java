package org.example.view;

import org.example.controller.GameController;
import org.example.model.Status;
import org.example.model.Tribut;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final GameController controller;
    private final Scanner scanner;

    public ConsoleView(GameController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the console application, displaying all required exercises.
     */
    public void run() {
        displayExercise1();
        System.out.println("--------------------------------------------------------------");
        displayExercise2();
        scanner.close();
    }

    private void displayExercise1() {
        System.out.println("Tributes loaded: " + controller.getTributes().size());
        System.out.println("Events loaded: " + controller.getEvents().size());
        System.out.println("Gifts loaded: " + controller.getGifts().size());
        System.out.println();

        controller.getTributes().forEach(System.out::println);
    }

    private void displayExercise2() {
        System.out.print("Input district: ");
        try {
            // Read the whole line and parse to avoid potential issues with the scanner's buffer.
            int district = Integer.parseInt(scanner.nextLine());
            System.out.println(); // Add a blank line for formatting, as in the example output.

            List<Tribut> filteredTributes = controller.filterTributesByDistrictAndStatus(district, Status.ALIVE);
            filteredTributes.forEach(System.out::println);

        } catch (NumberFormatException e) {
            System.out.println("\nInvalid input. Please enter a whole number for the district.");
        }
    }
}
