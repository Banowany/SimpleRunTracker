package com.example.simpleruntrackerbackend.entities.trainings;

import com.example.simpleruntrackerbackend.entities.segments.CompletedSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedSegment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("COMPLETED")
public class CompletedTraining extends Training {
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompletedSegment> segments = new ArrayList<>();

    public List<CompletedSegment> getSegments() {
        return segments;
    }

    public void setSegments(List<CompletedSegment> segments) {
        this.segments = segments;
    }
}
