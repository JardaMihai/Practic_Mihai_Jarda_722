package org.example;

import org.example.controller.GameController;
import org.example.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        // Initialize the controller which loads the data
        GameController controller = new GameController();

        // Initialize the view with the controller
        ConsoleView view = new ConsoleView(controller);

        // Run the application logic from the view
        view.run();
    }
}
