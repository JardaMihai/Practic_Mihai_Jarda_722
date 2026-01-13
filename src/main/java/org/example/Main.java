package org.example;

import org.example.controller.GameController;
import org.example.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        // The main method only initializes the components and starts the view.
        GameController controller = new GameController();
        ConsoleView view = new ConsoleView(controller);
        view.run();
    }
}
