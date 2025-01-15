package com.example.simpleruntrackerbackend.mappers;

import com.example.simpleruntrackerbackend.TrainingType;
import com.example.simpleruntrackerbackend.dtos.PlannedTrainingDTO;
import com.example.simpleruntrackerbackend.entities.trainings.PlannedTraining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PlannedTrainingMapper {
    private final PlannedSegmentMapper plannedSegmentMapper;

    @Autowired
    public PlannedTrainingMapper(PlannedSegmentMapper plannedSegmentMapper) {
        this.plannedSegmentMapper = plannedSegmentMapper;
    }

    public PlannedTraining fromDTO(PlannedTrainingDTO plannedTrainingDTO) {
        var plannedTraining = new PlannedTraining();
        plannedTraining.setTrainingType(TrainingType.valueOf(plannedTrainingDTO.getTrainingType()));
        plannedTraining.setDate(LocalDate.parse(plannedTrainingDTO.getDate()));
        plannedTraining.setComment(plannedTrainingDTO.getComment());
        var plannedSegments = plannedTrainingDTO.getSegments().stream().map(
                segment -> plannedSegmentMapper.fromDTO(segment, plannedTraining)
        ).toList();
        plannedTraining.setSegments(plannedSegments);
        return plannedTraining;
    }

    public PlannedTrainingDTO toDTO(PlannedTraining plannedTraining) {
        var plannedTrainingDTO = new PlannedTrainingDTO();
        plannedTrainingDTO.setId(plannedTraining.getId());
        plannedTrainingDTO.setTrainingType(plannedTraining.getTrainingType().name());
        plannedTrainingDTO.setDate(plannedTraining.getDate().toString());
        plannedTrainingDTO.setComment(plannedTraining.getComment());
        var plannedSegmentDTOs = plannedTraining.getSegments().stream().map(
                plannedSegmentMapper::toDTO
        ).toList();
        plannedTrainingDTO.setSegments(plannedSegmentDTOs);
        return plannedTrainingDTO;
    }
}
