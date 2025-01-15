package com.example.simpleruntrackerbackend.services;

import com.example.simpleruntrackerbackend.TrainingType;
import com.example.simpleruntrackerbackend.dtos.CompletedSegmentDTO;
import com.example.simpleruntrackerbackend.dtos.CompletedTrainingDTO;
import com.example.simpleruntrackerbackend.entities.segments.CompletedSegment;
import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.repositories.CompletedTrainingRepository;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CompletedTrainingService {
    private final CompletedTrainingRepository completedTrainingRepository;

    public CompletedTrainingService(CompletedTrainingRepository completedTrainingRepository) {
        this.completedTrainingRepository = completedTrainingRepository;
    }

    private CompletedSegment convertToCompletedSegment(
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

    private CompletedTraining convertToCompletedTraining(CompletedTrainingDTO completedTrainingDTO) {
        var completedTraining = new CompletedTraining();
        var completedSegments = completedTrainingDTO.getSegments().stream().map(
                segmentDTO -> convertToCompletedSegment(segmentDTO, completedTraining)
        ).toList();
        completedTraining.setSegments(completedSegments);
        completedTraining.setTrainingType(TrainingType.valueOf(completedTrainingDTO.getTrainingType()));
        completedTraining.setDate(LocalDate.parse(completedTrainingDTO.getDate()));
        completedTraining.setComment(completedTrainingDTO.getComment());
        return completedTraining;
    }

    private CompletedSegmentDTO convertToCompletedSegmentDTO(CompletedSegment completedSegment) {
        var completedSegmentDTO = new CompletedSegmentDTO();
        completedSegmentDTO.setDistanceInMeters(completedSegment.getDistanceInMeters());
        completedSegmentDTO.setDurationInSeconds(completedSegment.getDurationInSeconds());
        completedSegmentDTO.setAverageHeartRate(completedSegment.getAverageHeartRate());
        completedSegmentDTO.setName(completedSegment.getName());
        return completedSegmentDTO;
    }

    private CompletedTrainingDTO convertToCompletedTrainingDTO(CompletedTraining completedTraining) {
        var completedTrainingDTO = new CompletedTrainingDTO();
        completedTrainingDTO.setSegments(completedTraining.getSegments().stream().map(
                this::convertToCompletedSegmentDTO
        ).toList());
        completedTrainingDTO.setId(completedTraining.getId());
        completedTrainingDTO.setTrainingType(completedTraining.getTrainingType().name());
        completedTrainingDTO.setDate(completedTraining.getDate().toString());
        completedTrainingDTO.setComment(completedTraining.getComment());
        return completedTrainingDTO;
    }

    public CompletedTrainingDTO createCompletedTraining(CompletedTrainingDTO completedTrainingDTO) {
        var completedTraining = convertToCompletedTraining(completedTrainingDTO);

        CompletedTraining savedTraining = completedTrainingRepository.save(completedTraining);
        return convertToCompletedTrainingDTO(savedTraining);
    }

    public List<CompletedTrainingDTO> getAllCompletedTrainings() {
        return completedTrainingRepository.findAll().stream().map(
                this::convertToCompletedTrainingDTO
        ).toList();
    }

    public void deleteTraining(Long id) {
        completedTrainingRepository.deleteById(id);
    }
}
