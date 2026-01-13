package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Ignore any unknown properties in the JSON to make the model more robust
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    private int id;
    private String description;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

