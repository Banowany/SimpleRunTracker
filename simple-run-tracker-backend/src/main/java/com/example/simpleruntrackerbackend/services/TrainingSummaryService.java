package com.example.simpleruntrackerbackend.services;

import com.example.simpleruntrackerbackend.entities.TrainingSummary;
import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.entities.trainings.Training;
import com.example.simpleruntrackerbackend.repositories.CompletedTrainingRepository;
import com.example.simpleruntrackerbackend.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingSummaryService {
    private final CompletedTrainingRepository completedTrainingRepository;

    @Autowired
    public TrainingSummaryService(CompletedTrainingRepository completedTrainingRepository) {
        this.completedTrainingRepository = completedTrainingRepository;
    }

    public TrainingSummary generateSummary(LocalDate startDate, LocalDate endDate) {
        List<CompletedTraining> trainings = completedTrainingRepository.findTrainingsInPeriod(startDate, endDate);
        int totalTrainingCount = trainings.size();
        long totalDistance = 0L;
        long totalDuration = 0L;

        for (var training : trainings) {
            for (var segment : training.getSegments()) {
                totalDistance += segment.getDistanceInMeters();
                totalDuration += segment.getDurationInSeconds();
            }
        }

        return new TrainingSummary(totalTrainingCount, totalDuration, totalDistance, trainings);
    }
}
