package com.example.simpleruntrackerbackend.mappers;

import com.example.simpleruntrackerbackend.TrainingType;
import com.example.simpleruntrackerbackend.dtos.CompletedSegmentDTO;
import com.example.simpleruntrackerbackend.dtos.CompletedTrainingDTO;
import com.example.simpleruntrackerbackend.entities.segments.CompletedSegment;
import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CompletedTrainingMapper {
    private final CompletedSegmentMapper completedSegmentMapper;

    @Autowired
    public CompletedTrainingMapper(CompletedSegmentMapper completedSegmentMapper) {
        this.completedSegmentMapper = completedSegmentMapper;
    }

    public CompletedTraining fromDTO(CompletedTrainingDTO completedTrainingDTO) {
        var completedTraining = new CompletedTraining();
        var completedSegments = completedTrainingDTO.getSegments().stream().map(
                segmentDTO -> completedSegmentMapper.fromDTO(segmentDTO, completedTraining)
        ).toList();
        completedTraining.setSegments(completedSegments);
        completedTraining.setTrainingType(TrainingType.valueOf(completedTrainingDTO.getTrainingType()));
        completedTraining.setDate(LocalDate.parse(completedTrainingDTO.getDate()));
        completedTraining.setComment(completedTrainingDTO.getComment());
        return completedTraining;
    }

    public CompletedTrainingDTO toDTO(CompletedTraining completedTraining) {
        var completedTrainingDTO = new CompletedTrainingDTO();
        completedTrainingDTO.setSegments(completedTraining.getSegments().stream().map(
                completedSegmentMapper::toDTO
        ).toList());
        completedTrainingDTO.setId(completedTraining.getId());
        completedTrainingDTO.setTrainingType(completedTraining.getTrainingType().name());
        completedTrainingDTO.setDate(completedTraining.getDate().toString());
        completedTrainingDTO.setComment(completedTraining.getComment());
        return completedTrainingDTO;
    }
}
