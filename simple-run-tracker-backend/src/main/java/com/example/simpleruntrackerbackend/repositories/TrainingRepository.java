package com.example.simpleruntrackerbackend.repositories;

import com.example.simpleruntrackerbackend.entities.trainings.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    @Query("SELECT t FROM Training t WHERE t.date BETWEEN :startDate AND :endDate")
    List<Training> findTrainingsInPeriod(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
            );
}
