package com.example.simpleruntrackerbackend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Segment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    @JsonIgnore
    private Training training;

    private Long duration; //in seconds

    private Long distance; //in meters

    private Long averageHeartRate;

    public Segment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Long getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(Long averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }
}
