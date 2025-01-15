package com.example.simpleruntrackerbackend.controllers;

import com.example.simpleruntrackerbackend.dtos.CompletedTrainingDTO;
import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.entities.trainings.Training;
import com.example.simpleruntrackerbackend.services.CompletedTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
@CrossOrigin(origins = "http://localhost:5173")
public class CompletedTrainingController {
    private final CompletedTrainingService completedTrainingService;

    @Autowired
    public CompletedTrainingController(CompletedTrainingService completedTrainingService) {
        this.completedTrainingService = completedTrainingService;
    }

    @PostMapping
    public ResponseEntity<CompletedTrainingDTO> createTraining(@RequestBody CompletedTrainingDTO completedTrainingDTO) {
        CompletedTrainingDTO savedTraining = completedTrainingService.createCompletedTraining(completedTrainingDTO);
        return ResponseEntity.ok(savedTraining);
    }

    @GetMapping
    public ResponseEntity<List<CompletedTrainingDTO>> getTrainings() {
        List<CompletedTrainingDTO> trainings = completedTrainingService.getAllCompletedTrainings();
        return ResponseEntity.ok(trainings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        completedTrainingService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }
}
