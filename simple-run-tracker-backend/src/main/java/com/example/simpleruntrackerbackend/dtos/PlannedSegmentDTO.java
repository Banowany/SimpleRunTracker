package com.example.simpleruntrackerbackend.dtos;

public class PlannedSegmentDTO {
    private String name;
    private Integer plannedPaceInSecondsPerKm;
    private Long plannedDurationInSeconds;
    private Long plannedDistanceInMeters;
    private String planned_segment_type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlannedPaceInSecondsPerKm() {
        return plannedPaceInSecondsPerKm;
    }

    public void setPlannedPaceInSecondsPerKm(Integer plannedPaceInSecondsPerKm) {
        this.plannedPaceInSecondsPerKm = plannedPaceInSecondsPerKm;
    }

    public Long getPlannedDurationInSeconds() {
        return plannedDurationInSeconds;
    }

    public void setPlannedDurationInSeconds(Long plannedDurationInSeconds) {
        this.plannedDurationInSeconds = plannedDurationInSeconds;
    }

    public Long getPlannedDistanceInMeters() {
        return plannedDistanceInMeters;
    }

    public void setPlannedDistanceInMeters(Long plannedDistanceInMeters) {
        this.plannedDistanceInMeters = plannedDistanceInMeters;
    }

    public String getPlanned_segment_type() {
        return planned_segment_type;
    }

    public void setPlanned_segment_type(String planned_segment_type) {
        this.planned_segment_type = planned_segment_type;
    }
}
