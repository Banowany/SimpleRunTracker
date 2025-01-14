package com.example.simpleruntrackerbackend.dtos;

import java.util.List;

public class PlannedTrainingDTO {
    private long id;
    private String trainingType;
    private String date;
    private String comment;
    private List<PlannedSegmentDTO> segments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<PlannedSegmentDTO> getSegments() {
        return segments;
    }

    public void setSegments(List<PlannedSegmentDTO> segments) {
        this.segments = segments;
    }
}
