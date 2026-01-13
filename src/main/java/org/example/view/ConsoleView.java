package org.example.view;

import org.example.controller.GameController;
import org.example.model.Tribute;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private final GameController controller;

    public ConsoleView(GameController controller) {
        this.controller = controller;
    }

    public void run() {
        displayExercise1();
        displayExercise2();
        displayExercise3();
    }

    private void displayExercise1() {
        System.out.println("--- Exercise 1: Load Data ---");
        System.out.println("Tributes loaded: " + controller.getTributes().size());
        System.out.println("Events loaded: " + controller.getEvents().size());
        System.out.println("Gifts loaded: " + controller.getGifts().size());
        System.out.println();

        controller.getTributes().forEach(System.out::println);
        System.out.println("\n--------------------------------\n");
    }

    private void displayExercise2() {
        System.out.println("--- Exercise 2: Filter by District and Status ---");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input district: ");
            int district = scanner.nextInt();
            System.out.println();

            List<Tribute> filteredTributes = controller.filterTributesByDistrictAndStatus(district);
            if (filteredTributes.isEmpty()) {
                System.out.println("No ALIVE tributes found for district " + district);
            } else {
                filteredTributes.forEach(System.out::println);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
        System.out.println("\n--------------------------------\n");
    }

    private void displayExercise3() {
        System.out.println("--- Exercise 3: Sort Tributes ---");
        List<Tribute> sortedTributes = controller.getSortedTributes();
        sortedTributes.forEach(System.out::println);
        System.out.println("\n--------------------------------\n");
    }
}

