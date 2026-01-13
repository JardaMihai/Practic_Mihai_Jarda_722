package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Event;
import org.example.model.Gift;
import org.example.model.Status;
import org.example.model.Tribute;
import org.example.repository.JsonDataReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    public List<Tribute> filterTributesByDistrictAndStatus(int district) {
        return tributes.stream()
                .filter(tribute -> tribute.getDistrict() == district && tribute.getStatus() == Status.ALIVE)
                .collect(Collectors.toList());
    }

    public List<Tribute> getSortedTributes() {
        return tributes.stream()
                .sorted(Comparator.comparing(Tribute::getSkillLevel).reversed()
                        .thenComparing(Tribute::getName))
                .collect(Collectors.toList());
    }

    public void writeTributesToFile(List<Tribute> tributesToWrite, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            tributesToWrite.forEach(writer::println);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filename);
            e.printStackTrace();
        }
    }

    public int calculateComputedPoints(Event event) {
        int points = event.getPoints();
        int day = event.getDay();
        switch (event.getEventType()) {
            case FOUND_SUPPLIES:
                return points + 2 * day;
            case INJURED:
                return points - day;
            case ATTACK:
                return points * 2 + day;
            case HELPED_ALLY:
                return points + 5;
            case SPONSORED:
                return points + 10;
            default:
                return points; // Should not happen with the given data
        }
    }

    public List<Event> getFirstFiveEvents() {
        return events.stream().limit(5).collect(Collectors.toList());
    }
}

