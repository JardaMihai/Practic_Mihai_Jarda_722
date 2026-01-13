package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Event;
import org.example.model.Gift;
import org.example.model.Tribute;
import org.example.view.ConsoleView;

import java.util.List;

/**
 * The main controller of the application.
 * It orchestrates the data loading and the view rendering.
 */
public class AppController {

    private final JsonDataLoader dataLoader;
    private final ConsoleView view;

    public AppController() {
        this.dataLoader = new JsonDataLoader();
        this.view = new ConsoleView();
    }

    /**
     * Runs the main application logic.
     */
    public void run() {
        // 1. Load data using the data loader
        List<Tribute> tributes = dataLoader.loadData("tributes.json", new TypeReference<>() {});
        List<Event> events = dataLoader.loadData("events.json", new TypeReference<>() {});
        List<Gift> gifts = dataLoader.loadData("gifts.json", new TypeReference<>() {});

        // 2. Pass the data to the view for display
        view.displayCounts(tributes.size(), events.size(), gifts.size());
        view.displayAllTributes(tributes);
    }
}

