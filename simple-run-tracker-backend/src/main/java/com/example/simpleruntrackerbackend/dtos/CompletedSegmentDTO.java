package com.example.simpleruntrackerbackend.dtos;

public class CompletedSegmentDTO {
    private String name;
    private long durationInSeconds;
    private long distanceInMeters;
    private Long averageHeartRate;//optional

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public long getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(long distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    public Long getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(Long averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }
}
