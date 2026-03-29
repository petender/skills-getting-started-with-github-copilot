package com.mergington.highschool.controller;

import com.mergington.highschool.model.Activity;
import com.mergington.highschool.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/")
    public RedirectView root() {
        return new RedirectView("/index.html");
    }

    @GetMapping("/activities")
    public Map<String, Activity> getActivities() {
        return activityService.getActivities();
    }

    @PostMapping("/activities/{activityName}/signup")
    public ResponseEntity<Map<String, String>> signup(
            @PathVariable String activityName,
            @RequestParam String email) {
        String message = activityService.signup(activityName, email);
        return ResponseEntity.ok(Map.of("message", message));
    }
}
