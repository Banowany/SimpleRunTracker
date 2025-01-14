package com.example.simpleruntrackerbackend.dtos;

import java.util.List;

public class CompletedTrainingDTO {
    private long id;
    private String trainingType;
    private String date;
    private String comment;
    private List<CompletedSegmentDTO> segments;

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

    public List<CompletedSegmentDTO> getSegments() {
        return segments;
    }

    public void setSegments(List<CompletedSegmentDTO> segments) {
        this.segments = segments;
    }
}
