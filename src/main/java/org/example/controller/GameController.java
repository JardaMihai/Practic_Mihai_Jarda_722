package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Event;
import org.example.model.Gift;
import org.example.model.Status;
import org.example.model.Tribute;
import org.example.repository.JsonDataReader;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private List<Tribute> tributes;
    private List<Event> events;
    private List<Gift> gifts;

    public GameController() {
        loadData();
    }

    private void loadData() {
        tributes = JsonDataReader.readJsonFileToList("tributes.json", new TypeReference<>() {});
        events = JsonDataReader.readJsonFileToList("events.json", new TypeReference<>() {});
        gifts = JsonDataReader.readJsonFileToList("gifts.json", new TypeReference<>() {});
    }

    public List<Tribute> getTributes() {
        return tributes;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    /**
     * Filters tributes by district and ALIVE status.
     * Implements logic for Exercise 2.
     */
    public List<Tribute> filterTributesByDistrictAndStatus(int district) {
        return tributes.stream()
                .filter(tribute -> tribute.getDistrict() == district && tribute.getStatus() == Status.ALIVE)
                .collect(Collectors.toList());
    }

    /**
     * Sorts tributes by skill level (desc) and then by name (asc).
     * Implements logic for Exercise 3.
     */
    public List<Tribute> getSortedTributes() {
        return tributes.stream()
                .sorted(Comparator.comparing(Tribute::getSkillLevel).reversed()
                        .thenComparing(Tribute::getName))
                .collect(Collectors.toList());
    }
}

