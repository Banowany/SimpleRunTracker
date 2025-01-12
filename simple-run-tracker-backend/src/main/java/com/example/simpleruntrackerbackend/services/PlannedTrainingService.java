package com.example.simpleruntrackerbackend.services;

import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.entities.trainings.PlannedTraining;
import com.example.simpleruntrackerbackend.repositories.PlannedTrainingRepository;
import com.example.simpleruntrackerbackend.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlannedTrainingService {
    private final PlannedTrainingRepository plannedTrainingRepository;

    @Autowired
    public PlannedTrainingService(PlannedTrainingRepository plannedTrainingRepository) {
        this.plannedTrainingRepository = plannedTrainingRepository;
    }

    public PlannedTraining createPlannedTraining(PlannedTraining plannedTraining) {
        for (var segment : plannedTraining.getSegments()) {
            segment.setTraining(plannedTraining);
        }

        return plannedTrainingRepository.save(plannedTraining);
    }

    public List<PlannedTraining> getAllPlannedTrainings() {
        return plannedTrainingRepository.findAll();
    }

    public Optional<PlannedTraining> getPlannedTrainingsById(Long id) {
        return plannedTrainingRepository.findById(id);
    }
}
