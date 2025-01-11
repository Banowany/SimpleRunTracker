package com.example.simpleruntrackerbackend.entities;

import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.entities.trainings.Training;

import java.util.List;

public class TrainingSummary {
    private int totalTrainingCount;
    private long totalDuration;
    private long totalDistance;
    private List<CompletedTraining> trainings;

    public TrainingSummary(int totalTrainingCount, long totalDuration, long totalDistance, List<CompletedTraining> trainings) {
        this.totalTrainingCount = totalTrainingCount;
        this.totalDuration = totalDuration;
        this.totalDistance = totalDistance;
        this.trainings = trainings;
    }

    public int getTotalTrainingCount() {
        return totalTrainingCount;
    }

    public long getTotalDuration() {
        return totalDuration;
    }

    public long getTotalDistance() {
        return totalDistance;
    }

    public List<CompletedTraining> getTrainings() {
        return trainings;
    }
}
