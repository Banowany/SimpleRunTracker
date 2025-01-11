package com.example.simpleruntrackerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingSummaryService {
    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingSummaryService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public TrainingSummary generateSummary(LocalDate startDate, LocalDate endDate) {
        List<Training> trainings = trainingRepository.findTrainingsInPeriod(startDate, endDate);
        int totalTrainingCount = trainings.size();
        long totalDistance = 0L;
        long totalDuration = 0L;

        for (var training : trainings) {
            for (var segment : training.getSegments()) {
                totalDistance += segment.getDistance();
                totalDuration += segment.getDuration();
            }
        }

        return new TrainingSummary(totalTrainingCount, totalDuration, totalDistance, trainings);
    }
}
