package com.example.simpleruntrackerbackend.controllers;

import com.example.simpleruntrackerbackend.entities.trainings.PlannedTraining;
import com.example.simpleruntrackerbackend.services.PlannedTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planned-trainings")
public class PlannedTrainingController {
    private final PlannedTrainingService plannedTrainingService;

    @Autowired
    public PlannedTrainingController(PlannedTrainingService plannedTrainingService) {
        this.plannedTrainingService = plannedTrainingService;
    }

    @PostMapping
    public ResponseEntity<PlannedTraining> createPlannedTraining(
            @RequestBody PlannedTraining plannedTraining
    ) {
        PlannedTraining savedTraining = plannedTrainingService.createPlannedTraining(plannedTraining);
        return ResponseEntity.ok(savedTraining);
    }

    @GetMapping
    public List<PlannedTraining> getAllPlannedTrainings() {
        return plannedTrainingService.getAllPlannedTrainings();
    }
}
