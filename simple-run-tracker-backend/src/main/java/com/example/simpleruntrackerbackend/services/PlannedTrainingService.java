package com.example.simpleruntrackerbackend.services;

import com.example.simpleruntrackerbackend.TrainingType;
import com.example.simpleruntrackerbackend.dtos.PlannedSegmentDTO;
import com.example.simpleruntrackerbackend.dtos.PlannedTrainingDTO;
import com.example.simpleruntrackerbackend.entities.segments.PlannedDistanceSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedTimeSegment;
import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.entities.trainings.PlannedTraining;
import com.example.simpleruntrackerbackend.mappers.PlannedTrainingMapper;
import com.example.simpleruntrackerbackend.repositories.PlannedTrainingRepository;
import com.example.simpleruntrackerbackend.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlannedTrainingService {
    private final PlannedTrainingRepository plannedTrainingRepository;
    private final PlannedTrainingMapper plannedTrainingMapper;

    @Autowired
    public PlannedTrainingService(PlannedTrainingRepository plannedTrainingRepository, PlannedTrainingMapper plannedTrainingMapper) {
        this.plannedTrainingRepository = plannedTrainingRepository;
        this.plannedTrainingMapper = plannedTrainingMapper;
    }

    public PlannedTrainingDTO createPlannedTraining(PlannedTrainingDTO plannedTrainingDTO) {
        var plannedTraining = plannedTrainingMapper.fromDTO(plannedTrainingDTO);

        return plannedTrainingMapper.toDTO(plannedTrainingRepository.save(plannedTraining));
    }

    public List<PlannedTrainingDTO> getAllPlannedTrainings() {
        return plannedTrainingRepository.findAll().stream().map(
                plannedTrainingMapper::toDTO
        ).toList();
    }

    public void deletePlannedTraining(Long id) {
        plannedTrainingRepository.deleteById(id);
    }
}
