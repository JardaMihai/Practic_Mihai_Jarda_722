package org.example;

import org.example.controller.GameController;
import org.example.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();

        ConsoleView view = new ConsoleView(controller);

        view.run();
    }
}
