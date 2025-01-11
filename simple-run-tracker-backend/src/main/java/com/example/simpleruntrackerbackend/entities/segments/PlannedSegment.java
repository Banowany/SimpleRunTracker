package com.example.simpleruntrackerbackend.entities.segments;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "planned_segment_type")
public class PlannedSegment extends Segment {
    private int plannedPaceInSecondsPerKm;

    public int getPlannedPaceInSecondsPerKm() {
        return plannedPaceInSecondsPerKm;
    }

    public void setPlannedPaceInSecondsPerKm(int plannedPaceInSecondsPerKm) {
        this.plannedPaceInSecondsPerKm = plannedPaceInSecondsPerKm;
    }
}
