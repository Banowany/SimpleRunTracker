//package com.example.simpleruntrackerbackend.controllers;
//
//import com.example.simpleruntrackerbackend.entities.trainings.Training;
//import com.example.simpleruntrackerbackend.services.TrainingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/trainings")
//public class TrainingController {
//
//    private final TrainingService trainingService;
//
//    @Autowired
//    public TrainingController(TrainingService trainingService) {
//        this.trainingService = trainingService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Training> createTraining(@RequestBody Training training) {
//        Training savedTraining = trainingService.createTraining(training);
//        return ResponseEntity.ok(savedTraining);
//    }
//
//    @GetMapping
//    public List<Training> getAllTrainings() {
//        return trainingService.getAllTrainings();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Training> getTrainingById(@PathVariable Long id) {
//        return trainingService.getTrainingById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//}
