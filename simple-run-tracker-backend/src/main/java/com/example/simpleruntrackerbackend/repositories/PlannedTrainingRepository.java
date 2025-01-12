package com.example.simpleruntrackerbackend.repositories;

import com.example.simpleruntrackerbackend.entities.trainings.PlannedTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PlannedTrainingRepository extends JpaRepository<PlannedTraining, Long> {
    @Query("SELECT t FROM PlannedTraining t WHERE t.date BETWEEN :startDate AND :endDate")
    List<PlannedTraining> findTrainingsInPeriod(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
