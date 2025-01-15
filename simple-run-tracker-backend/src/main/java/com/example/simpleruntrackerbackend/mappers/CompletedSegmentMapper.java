package com.example.simpleruntrackerbackend.mappers;

import com.example.simpleruntrackerbackend.dtos.CompletedSegmentDTO;
import com.example.simpleruntrackerbackend.entities.segments.CompletedSegment;
import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import org.springframework.stereotype.Component;

@Component
public class CompletedSegmentMapper {

    public CompletedSegment fromDTO(
            CompletedSegmentDTO completedSegmentDTO,
            CompletedTraining completedTraining
    ) {
        var completedSegment = new CompletedSegment();
        completedSegment.setTraining(completedTraining);
        completedSegment.setDistanceInMeters(completedSegmentDTO.getDistanceInMeters());
        completedSegment.setDurationInSeconds(completedSegmentDTO.getDurationInSeconds());
        completedSegment.setAverageHeartRate(completedSegmentDTO.getAverageHeartRate());
        completedSegment.setName(completedSegmentDTO.getName());
        return completedSegment;
    }

    public CompletedSegmentDTO toDTO(CompletedSegment completedSegment) {
        var completedSegmentDTO = new CompletedSegmentDTO();
        completedSegmentDTO.setDistanceInMeters(completedSegment.getDistanceInMeters());
        completedSegmentDTO.setDurationInSeconds(completedSegment.getDurationInSeconds());
        completedSegmentDTO.setAverageHeartRate(completedSegment.getAverageHeartRate());
        completedSegmentDTO.setName(completedSegment.getName());
        return completedSegmentDTO;
    }

}
