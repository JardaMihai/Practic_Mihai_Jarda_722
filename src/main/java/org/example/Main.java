package org.example;

import org.example.controller.AppController;

public class Main {
    public static void main(String[] args) {
        // In main, we only initialize and start the application controller.
        // All business logic is handled within the MVC structure.
        AppController appController = new AppController();
        appController.run();
    }
}

