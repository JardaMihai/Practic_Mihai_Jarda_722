package org.example.model;

// Numele din diagramă: Tribut
// Am folosit nume de câmpuri care corespund direct cu cheile din JSON pentru a simplifica parsarea.
public class Tribute {
    private int id;
    private String name;
    private int district; // distrikt in diagram
    private Status status;
    private int skillLevel;

    // Getters and Setters
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
        // Format: id | name | D<district> | status | skill=<skillLevel>
        return String.format("%d | %s | D%d | %s | skill=%d",
                id, name, district, status, skillLevel);
    }
}

