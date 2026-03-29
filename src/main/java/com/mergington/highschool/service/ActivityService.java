package com.mergington.highschool.service;

import com.mergington.highschool.exception.ApiException;
import com.mergington.highschool.model.Activity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityService {

    private final Map<String, Activity> activities = new LinkedHashMap<>();

    public ActivityService() {
        activities.put("Chess Club", new Activity(
                "Learn strategies and compete in chess tournaments",
                "Fridays, 3:30 PM - 5:00 PM",
                12,
                List.of("michael@mergington.edu", "daniel@mergington.edu")
        ));
        activities.put("Programming Class", new Activity(
                "Learn programming fundamentals and build software projects",
                "Tuesdays and Thursdays, 3:30 PM - 4:30 PM",
                20,
                List.of("emma@mergington.edu", "sophia@mergington.edu")
        ));
        activities.put("Gym Class", new Activity(
                "Physical education and sports activities",
                "Mondays, Wednesdays, Fridays, 2:00 PM - 3:00 PM",
                30,
                List.of("john@mergington.edu", "olivia@mergington.edu")
        ));
        activities.put("Art Club", new Activity(
                "Explore painting, drawing, and other visual arts",
                "Wednesdays, 3:30 PM - 5:00 PM",
                15,
                List.of("lucas@mergington.edu", "mia@mergington.edu")
        ));
        activities.put("Drama Club", new Activity(
                "Rehearse and perform theatrical productions",
                "Tuesdays and Thursdays, 4:00 PM - 5:30 PM",
                20,
                List.of("isabella@mergington.edu", "liam@mergington.edu")
        ));
    }

    public Map<String, Activity> getActivities() {
        return activities;
    }

    public String signup(String activityName, String email) {
        Activity activity = activities.get(activityName);
        if (activity == null) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Activity not found");
        }

        if (!email.contains("@") || !email.endsWith("@mergington.edu")) {
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "Only Mergington student emails (@mergington.edu) can sign up");
        }

        if (activity.getParticipants().contains(email)) {
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "Student is already signed up for this activity");
        }

        activity.getParticipants().add(email);
        return "Signed up " + email + " for " + activityName;
    }
}
