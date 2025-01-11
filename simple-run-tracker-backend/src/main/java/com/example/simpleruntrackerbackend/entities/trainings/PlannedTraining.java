package com.example.simpleruntrackerbackend.entities.trainings;

import com.example.simpleruntrackerbackend.entities.segments.PlannedSegment;
import com.example.simpleruntrackerbackend.entities.segments.Segment;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("PLANNED")
public class PlannedTraining extends Training {
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlannedSegment> segments = new ArrayList<>();

    public List<PlannedSegment> getSegments() {
        return segments;
    }

    public void setSegments(List<PlannedSegment> segments) {
        this.segments = segments;
    }
}
