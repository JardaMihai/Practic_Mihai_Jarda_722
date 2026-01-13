package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Ereignis;
import org.example.model.SponsorGeschenk;
import org.example.model.Status;
import org.example.model.Tribut;
import org.example.repository.JsonDataReader;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private List<Tribut> tributes;
    private List<Ereignis> events;
    private List<SponsorGeschenk> gifts;

    public GameController() {
        loadData();
    }

    private void loadData() {
        JsonDataReader reader = new JsonDataReader();
        try {
            tributes = reader.readListFromJsonFile("tributes.json", new TypeReference<List<Tribut>>() {});
            events = reader.readListFromJsonFile("events.json", new TypeReference<List<Ereignis>>() {});
            gifts = reader.readListFromJsonFile("gifts.json", new TypeReference<List<SponsorGeschenk>>() {});
        } catch (IOException e) {
            System.err.println("Error loading data from JSON files: " + e.getMessage());
            // Initialize to empty lists to avoid NullPointerExceptions in case of an error.
            tributes = Collections.emptyList();
            events = Collections.emptyList();
            gifts = Collections.emptyList();
        }
    }

    public List<Tribut> getTributes() {
        return tributes;
    }

    public List<Ereignis> getEvents() {
        return events;
    }

    public List<SponsorGeschenk> getGifts() {
        return gifts;
    }

    /**
     * Business logic to filter tributes based on district and status.
     * @param district The district to filter by.
     * @param status The status to filter by.
     * @return A new list of tributes matching the criteria.
     */
    public List<Tribut> filterTributesByDistrictAndStatus(int district, Status status) {
        return tributes.stream()
                .filter(tribut -> tribut.getDistrikt() == district && tribut.getStatus() == status)
                .collect(Collectors.toList());
    }
}
