package com.example.simpleruntrackerbackend.services;

import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.repositories.CompletedTrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompletedTrainingService {
    private final CompletedTrainingRepository completedTrainingRepository;

    public CompletedTrainingService(CompletedTrainingRepository completedTrainingRepository) {
        this.completedTrainingRepository = completedTrainingRepository;
    }

    public CompletedTraining createCompletedTraining(CompletedTraining completedTraining) {
        return completedTrainingRepository.save(completedTraining);
    }

    public List<CompletedTraining> getAllCompletedTrainings() {
        return completedTrainingRepository.findAll();
    }

    public Optional<CompletedTraining> getCompletedTrainingById(Long id) {
        return completedTrainingRepository.findById(id);
    }
}
