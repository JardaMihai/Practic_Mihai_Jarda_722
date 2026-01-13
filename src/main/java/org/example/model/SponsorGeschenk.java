package org.example.model;

public class SponsorGeschenk {
    private int id;
    private int tributId;
    private String itemName;
    private int value;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
