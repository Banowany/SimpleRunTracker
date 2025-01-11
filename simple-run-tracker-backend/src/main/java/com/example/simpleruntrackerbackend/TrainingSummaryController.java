package com.example.simpleruntrackerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/trainingSummary")
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
