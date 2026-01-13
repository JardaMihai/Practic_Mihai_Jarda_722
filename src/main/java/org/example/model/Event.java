package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

// Numele din diagramă: Ereignis
public class Event {
    private int id;
    private int tributeId;
    @JsonProperty("type") // Mapare explicită de la "type" (JSON) la "eventType" (Java)
    private EventType eventType; // typ in diagram
    private int points;
    private int day;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTributeId() {
        return tributeId;
    }

    public void setTributeId(int tributeId) {
        this.tributeId = tributeId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

