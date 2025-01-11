//package com.example.simpleruntrackerbackend.services;
//
//import com.example.simpleruntrackerbackend.entities.segments.Segment;
//import com.example.simpleruntrackerbackend.entities.trainings.Training;
//import com.example.simpleruntrackerbackend.repositories.TrainingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TrainingService {
//    private final TrainingRepository trainingRepository;
//
//    @Autowired
//    public TrainingService(TrainingRepository trainingRepository) {
//        this.trainingRepository = trainingRepository;
//    }
//
//    public Training createTraining(Training training) {
//        for (Segment segment : training.getSegments()) {
//            segment.setTraining(training);
//        }
//
//        return trainingRepository.save(training);
//    }
//
//    public List<Training> getAllTrainings() {
//        return trainingRepository.findAll();
//    }
//
//    public Optional<Training> getTrainingById(Long id) {
//        return trainingRepository.findById(id);
//    }
//}
