package com.example.simpleruntrackerbackend.entities.segments;

import jakarta.persistence.Entity;

@Entity
public class CompletedSegment extends Segment {
    private long durationInSeconds;

    private long distanceInMeters;

    private Long averageHeartRate;//optional

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
