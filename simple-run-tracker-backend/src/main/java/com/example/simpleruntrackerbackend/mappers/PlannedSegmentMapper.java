package com.example.simpleruntrackerbackend.mappers;

import com.example.simpleruntrackerbackend.TrainingType;
import com.example.simpleruntrackerbackend.dtos.PlannedSegmentDTO;
import com.example.simpleruntrackerbackend.dtos.PlannedTrainingDTO;
import com.example.simpleruntrackerbackend.entities.segments.PlannedDistanceSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedTimeSegment;
import com.example.simpleruntrackerbackend.entities.trainings.PlannedTraining;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PlannedSegmentMapper {
    public PlannedSegment fromDTO(PlannedSegmentDTO plannedSegmentDTO, PlannedTraining plannedTraining) {
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

    public PlannedSegmentDTO toDTO(PlannedSegment plannedSegment) {
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
}
