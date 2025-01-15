package com.example.simpleruntrackerbackend.services;

import com.example.simpleruntrackerbackend.TrainingType;
import com.example.simpleruntrackerbackend.dtos.CompletedSegmentDTO;
import com.example.simpleruntrackerbackend.dtos.CompletedTrainingDTO;
import com.example.simpleruntrackerbackend.entities.segments.CompletedSegment;
import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.mappers.CompletedTrainingMapper;
import com.example.simpleruntrackerbackend.repositories.CompletedTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CompletedTrainingService {
    private final CompletedTrainingRepository completedTrainingRepository;
    private final CompletedTrainingMapper completedTrainingMapper;

    @Autowired
    public CompletedTrainingService(CompletedTrainingRepository completedTrainingRepository, CompletedTrainingMapper completedTrainingMapper) {
        this.completedTrainingRepository = completedTrainingRepository;
        this.completedTrainingMapper = completedTrainingMapper;
    }



    public CompletedTrainingDTO createCompletedTraining(CompletedTrainingDTO completedTrainingDTO) {
        var completedTraining = completedTrainingMapper.fromDTO(completedTrainingDTO);

        CompletedTraining savedTraining = completedTrainingRepository.save(completedTraining);
        return completedTrainingMapper.toDTO(savedTraining);
    }

    public List<CompletedTrainingDTO> getAllCompletedTrainings() {
        return completedTrainingRepository.findAll().stream().map(
                completedTrainingMapper::toDTO
        ).toList();
    }

    public void deleteTraining(Long id) {
        completedTrainingRepository.deleteById(id);
    }
}
