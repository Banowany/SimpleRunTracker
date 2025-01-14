package com.example.simpleruntrackerbackend.controllers;

import com.example.simpleruntrackerbackend.services.TrainingSummaryService;
import com.example.simpleruntrackerbackend.entities.TrainingSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/trainingSummary")
@CrossOrigin(origins = "http://localhost:5173")
public class TrainingSummaryController {
    private final TrainingSummaryService trainingSummaryService;

    @Autowired
    public TrainingSummaryController(TrainingSummaryService trainingSummaryService) {
        this.trainingSummaryService = trainingSummaryService;
    }

    @GetMapping
    public TrainingSummary getSummary(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        return trainingSummaryService.generateSummary(start, end);
    }
}
