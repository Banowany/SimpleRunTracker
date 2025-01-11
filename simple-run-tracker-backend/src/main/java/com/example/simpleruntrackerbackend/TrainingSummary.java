package com.example.simpleruntrackerbackend;

import java.util.List;

public class TrainingSummary {
    private int totalTrainingCount;
    private long totalDuration;
    private long totalDistance;
    private List<Training> trainings;

    public TrainingSummary(int totalTrainingCount, long totalDuration, long totalDistance, List<Training> trainings) {
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

    public List<Training> getTrainings() {
        return trainings;
    }
}
