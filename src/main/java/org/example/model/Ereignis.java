package org.example.model;

public class Ereignis {
    private int id;
    private int tributId;
    private EventTyp typ;
    private int points;
    private int day;

    // Getters and Setters for Jackson deserialization
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTributId() {
        return tributId;
    }

    public void setTributId(int tributId) {
        this.tributId = tributId;
    }

    public EventTyp getTyp() {
        return typ;
    }

    public void setTyp(EventTyp typ) {
        this.typ = typ;
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
