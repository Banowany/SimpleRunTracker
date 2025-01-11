package com.example.simpleruntrackerbackend.entities.segments;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("TIME")
public class PlannedTimeSegment extends PlannedSegment {
    private long durationInSeconds;

    public long getPlannedDurationInSeconds() {
        return durationInSeconds;
    }

    public void setPlannedDurationInSeconds(long plannedDurationInSeconds) {
        this.durationInSeconds = plannedDurationInSeconds;
    }
}
