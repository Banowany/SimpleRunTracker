package com.example.simpleruntrackerbackend.entities.trainings;


import com.example.simpleruntrackerbackend.TrainingType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "which_training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private TrainingType trainingType;

    private LocalDate date;

    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
