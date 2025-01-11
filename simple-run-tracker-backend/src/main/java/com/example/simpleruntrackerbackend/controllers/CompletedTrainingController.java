package com.example.simpleruntrackerbackend.controllers;

import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.entities.trainings.Training;
import com.example.simpleruntrackerbackend.services.CompletedTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
public class CompletedTrainingController {
    private final CompletedTrainingService completedTrainingService;

    @Autowired
    public CompletedTrainingController(CompletedTrainingService completedTrainingService) {
        this.completedTrainingService = completedTrainingService;
    }

    @PostMapping
    public ResponseEntity<Training> createCompletedTraining(@RequestBody CompletedTraining training) {
        Training savedTraining = completedTrainingService.createCompletedTraining(training);
        return ResponseEntity.ok(savedTraining);
    }

    @GetMapping
    public List<CompletedTraining> getAllCompletedTrainings() {
        return completedTrainingService.getAllCompletedTrainings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompletedTraining> getTrainingById(@PathVariable Long id) {
        return completedTrainingService.getCompletedTrainingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
