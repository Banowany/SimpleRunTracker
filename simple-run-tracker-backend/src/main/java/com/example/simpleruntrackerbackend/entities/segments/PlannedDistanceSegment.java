package com.example.simpleruntrackerbackend.entities.segments;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("DISTANCE")
public class PlannedDistanceSegment extends PlannedSegment {
    private long distanceInMeters;

    public long getPlannedDistanceInMeters() {
        return distanceInMeters;
    }

    public void setPlannedDistanceInMeters(long plannedDistanceInMeters) {
        this.distanceInMeters = plannedDistanceInMeters;
    }
}
