package com.example.simpleruntrackerbackend.services;

import com.example.simpleruntrackerbackend.TrainingType;
import com.example.simpleruntrackerbackend.dtos.PlannedSegmentDTO;
import com.example.simpleruntrackerbackend.dtos.PlannedTrainingDTO;
import com.example.simpleruntrackerbackend.entities.segments.PlannedDistanceSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedTimeSegment;
import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.entities.trainings.PlannedTraining;
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

    @Autowired
    public PlannedTrainingService(PlannedTrainingRepository plannedTrainingRepository) {
        this.plannedTrainingRepository = plannedTrainingRepository;
    }

    private PlannedSegment convertToPlannedSegment(PlannedSegmentDTO plannedSegmentDTO, PlannedTraining plannedTraining) {
        if (plannedSegmentDTO.getPlanned_segment_type().equals("time")) {
            var plannedTimeSegment = new PlannedTimeSegment();
            plannedTimeSegment.setName(plannedSegmentDTO.getName());
            plannedTimeSegment.setTraining(plannedTraining);
            plannedTimeSegment.setPlannedPaceInSecondsPerKm(plannedSegmentDTO.getPlannedPaceInSecondsPerKm());
            plannedTimeSegment.setPlannedDurationInSeconds(plannedSegmentDTO.getPlannedDurationInSeconds());
            return plannedTimeSegment;
        }
        var plannedDistanceSegment = new PlannedDistanceSegment();
        plannedDistanceSegment.setName(plannedSegmentDTO.getName());
        plannedDistanceSegment.setTraining(plannedTraining);
        plannedDistanceSegment.setPlannedPaceInSecondsPerKm(plannedSegmentDTO.getPlannedPaceInSecondsPerKm());
        plannedDistanceSegment.setPlannedDistanceInMeters(plannedSegmentDTO.getPlannedDistanceInMeters());
        return plannedDistanceSegment;
    }

    private PlannedTraining convertToPlannedTraining(PlannedTrainingDTO plannedTrainingDTO) {
        var plannedTraining = new PlannedTraining();
        plannedTraining.setTrainingType(TrainingType.valueOf(plannedTrainingDTO.getTrainingType()));
        plannedTraining.setDate(LocalDate.parse(plannedTrainingDTO.getDate()));
        plannedTraining.setComment(plannedTrainingDTO.getComment());
        var plannedSegments = plannedTrainingDTO.getSegments().stream().map(
                segment -> convertToPlannedSegment(segment, plannedTraining)
        ).toList();
        plannedTraining.setSegments(plannedSegments);
        return plannedTraining;
    }

    private PlannedSegmentDTO convertToPlannedSegmentDTO(PlannedSegment plannedSegment) {
        var plannedSegmentDTO = new PlannedSegmentDTO();
        plannedSegmentDTO.setName(plannedSegment.getName());
        plannedSegmentDTO.setPlannedPaceInSecondsPerKm(plannedSegment.getPlannedPaceInSecondsPerKm());
        if (plannedSegment instanceof PlannedTimeSegment) {
            plannedSegmentDTO.setPlannedDurationInSeconds(((PlannedTimeSegment) plannedSegment).getPlannedDurationInSeconds());
            plannedSegmentDTO.setPlanned_segment_type("time");
        } else {
            plannedSegmentDTO.setPlannedDistanceInMeters(((PlannedDistanceSegment) plannedSegment).getPlannedDistanceInMeters());
            plannedSegmentDTO.setPlanned_segment_type("distance");
        }
        return plannedSegmentDTO;
    }

    private PlannedTrainingDTO convertToPlannedTrainingDTO(PlannedTraining plannedTraining) {
        var plannedTrainingDTO = new PlannedTrainingDTO();
        plannedTrainingDTO.setId(plannedTraining.getId());
        plannedTrainingDTO.setTrainingType(plannedTraining.getTrainingType().name());
        plannedTrainingDTO.setDate(plannedTraining.getDate().toString());
        plannedTrainingDTO.setComment(plannedTraining.getComment());
        var plannedSegmentDTOs = plannedTraining.getSegments().stream().map(
                this::convertToPlannedSegmentDTO
        ).toList();
        plannedTrainingDTO.setSegments(plannedSegmentDTOs);
        return plannedTrainingDTO;
    }

    public PlannedTrainingDTO createPlannedTraining(PlannedTrainingDTO plannedTrainingDTO) {
        var plannedTraining = convertToPlannedTraining(plannedTrainingDTO);

        return convertToPlannedTrainingDTO(plannedTrainingRepository.save(plannedTraining));
    }

    public List<PlannedTrainingDTO> getAllPlannedTrainings() {
        return plannedTrainingRepository.findAll().stream().map(
                this::convertToPlannedTrainingDTO
        ).toList();
    }

    public void deletePlannedTraining(Long id) {
        plannedTrainingRepository.deleteById(id);
    }
}
