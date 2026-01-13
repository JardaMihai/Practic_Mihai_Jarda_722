package org.example.model;

public class Tribute {
    private int id;
    private String name;
    private int district;
    private String status;
    private int skillLevel;

    // Getters and Setters are used by Jackson for deserialization
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

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    // A custom toString for the required output format
    @Override
    public String toString() {
        return String.format("%d | %s | D%d | %s | skill=%d",
                id, name, district, status, skillLevel);
    }
}

