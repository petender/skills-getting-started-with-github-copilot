package com.mergington.highschool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    private String description;
    private String schedule;

    @JsonProperty("max_participants")
    private int maxParticipants;

    private List<String> participants;

    public Activity(String description, String schedule, int maxParticipants, List<String> participants) {
        this.description = description;
        this.schedule = schedule;
        this.maxParticipants = maxParticipants;
        this.participants = new ArrayList<>(participants);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }
}
