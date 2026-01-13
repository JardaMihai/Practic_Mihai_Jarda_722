package org.example.model;

public class Tribut {
    private int id;
    private String name;
    private int distrikt;
    private Status status;
    private int skillLevel;

    // Getters and Setters for Jackson deserialization
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistrikt() {
        return distrikt;
    }

    public void setDistrikt(int distrikt) {
        this.distrikt = distrikt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return String.format("%d | %s | D%d | %s | skill=%d",
                id, name, distrikt, status, skillLevel);
    }
}
