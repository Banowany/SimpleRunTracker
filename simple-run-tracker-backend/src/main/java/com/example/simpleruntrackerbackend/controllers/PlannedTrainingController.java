package com.example.simpleruntrackerbackend.controllers;

import com.example.simpleruntrackerbackend.dtos.PlannedTrainingDTO;
import com.example.simpleruntrackerbackend.entities.trainings.PlannedTraining;
import com.example.simpleruntrackerbackend.services.PlannedTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planned-trainings")
@CrossOrigin(origins = "http://localhost:5173")
public class PlannedTrainingController {
    private final PlannedTrainingService plannedTrainingService;

    @Autowired
    public PlannedTrainingController(PlannedTrainingService plannedTrainingService) {
        this.plannedTrainingService = plannedTrainingService;
    }

    @PostMapping
    public ResponseEntity<PlannedTrainingDTO> createPlannedTraining(
            @RequestBody PlannedTrainingDTO plannedTrainingDTO
    ) {
        PlannedTrainingDTO savedTraining = plannedTrainingService.createPlannedTraining(plannedTrainingDTO);
        return ResponseEntity.ok(savedTraining);
    }

    @GetMapping
    public ResponseEntity<List<PlannedTrainingDTO>> getPlannedTrainings() {
        return ResponseEntity.ok(plannedTrainingService.getAllPlannedTrainings());
    }
}
