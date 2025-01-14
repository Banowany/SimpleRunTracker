package com.example.simpleruntrackerbackend;

import com.example.simpleruntrackerbackend.entities.segments.CompletedSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedDistanceSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedSegment;
import com.example.simpleruntrackerbackend.entities.segments.PlannedTimeSegment;
import com.example.simpleruntrackerbackend.entities.trainings.CompletedTraining;
import com.example.simpleruntrackerbackend.entities.trainings.PlannedTraining;
import com.example.simpleruntrackerbackend.entities.trainings.Training;
import com.example.simpleruntrackerbackend.repositories.TrainingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class BeginDataLoader implements CommandLineRunner {
    private final TrainingRepository trainingRepository;
    public BeginDataLoader(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    private Training createTraining1() {
        CompletedTraining training = new CompletedTraining();
        training.setTrainingType(TrainingType.LONG);
        training.setDate(LocalDate.of(2025, 1, 1));
        training.setComment("First training in 2025");

        CompletedSegment segment1 = new CompletedSegment();
        segment1.setName("Warm-up");
        segment1.setDurationInSeconds(600L);
        segment1.setDistanceInMeters(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        CompletedSegment segment2 = new CompletedSegment();
        segment2.setName("Main part");
        segment2.setDurationInSeconds(1800L);
        segment2.setDistanceInMeters(3000L);
        segment2.setAverageHeartRate(120L);
        segment2.setTraining(training);

        CompletedSegment segment3 = new CompletedSegment();
        segment3.setName("Cool-down");
        segment3.setDurationInSeconds(600L);
        segment3.setDistanceInMeters(1000L);
        segment3.setAverageHeartRate(100L);
        segment3.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3));

        return training;
    }

    private Training createTraining2() {
        CompletedTraining training = new CompletedTraining();
        training.setTrainingType(TrainingType.SPEED);
        training.setDate(LocalDate.of(2025, 1, 3));
        training.setComment("Second training in 2025 - speed training");

        CompletedSegment segment1 = new CompletedSegment();
        segment1.setName("Warm-up");
        segment1.setDurationInSeconds(600L);
        segment1.setDistanceInMeters(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        CompletedSegment segment2 = new CompletedSegment();
        segment2.setName("Main part");
        segment2.setDurationInSeconds(1800L);
        segment2.setDistanceInMeters(3000L);
        segment2.setAverageHeartRate(120L);
        segment2.setTraining(training);

        //jogs segments 4x100m/100m
        CompletedSegment segment3 = new CompletedSegment();
        segment3.setName("Fast jog 100m 1");
        segment3.setDurationInSeconds(30L);
        segment3.setDistanceInMeters(100L);
        segment3.setAverageHeartRate(null);
        segment3.setTraining(training);

        CompletedSegment segment4 = new CompletedSegment();
        segment4.setName("Slow jog 100m 1");
        segment4.setDurationInSeconds(60L);
        segment4.setDistanceInMeters(100L);
        segment4.setAverageHeartRate(null);
        segment4.setTraining(training);

        CompletedSegment segment5 = new CompletedSegment();
        segment5.setName("Fast jog 100m 2");
        segment5.setDurationInSeconds(30L);
        segment5.setDistanceInMeters(100L);
        segment5.setAverageHeartRate(null);
        segment5.setTraining(training);

        CompletedSegment segment6 = new CompletedSegment();
        segment6.setName("Slow jog 100m 2");
        segment6.setDurationInSeconds(60L);
        segment6.setDistanceInMeters(100L);
        segment6.setAverageHeartRate(null);
        segment6.setTraining(training);

        CompletedSegment segment7 = new CompletedSegment();
        segment7.setName("Fast jog 100m 3");
        segment7.setDurationInSeconds(30L);
        segment7.setDistanceInMeters(100L);
        segment7.setAverageHeartRate(null);
        segment7.setTraining(training);

        CompletedSegment segment8 = new CompletedSegment();
        segment8.setName("Slow jog 100m 3");
        segment8.setDurationInSeconds(60L);
        segment8.setDistanceInMeters(100L);
        segment8.setAverageHeartRate(null);
        segment8.setTraining(training);

        CompletedSegment segment9 = new CompletedSegment();
        segment9.setName("Fast jog 100m 4");
        segment9.setDurationInSeconds(30L);
        segment9.setDistanceInMeters(100L);
        segment9.setAverageHeartRate(null);
        segment9.setTraining(training);

        CompletedSegment segment10 = new CompletedSegment();
        segment10.setName("Slow jog 100m 4");
        segment10.setDurationInSeconds(60L);
        segment10.setDistanceInMeters(100L);
        segment10.setAverageHeartRate(null);
        segment10.setTraining(training);

        CompletedSegment segment11 = new CompletedSegment();
        segment11.setName("Cool-down");
        segment11.setDistanceInMeters(1000L);
        segment11.setDurationInSeconds(600L);
        segment11.setAverageHeartRate(100L);
        segment11.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3, segment4, segment5, segment6, segment7, segment8, segment9, segment10, segment11));

        return training;
    }

    private Training createTraining3() {
        CompletedTraining training = new CompletedTraining();
        training.setTrainingType(TrainingType.LONG);
        training.setDate(LocalDate.of(2025, 1, 4));
        training.setComment("Easy run 10.01.2025");

        CompletedSegment segment1 = new CompletedSegment();
        segment1.setName("Warm-up");
        segment1.setDurationInSeconds(600L);
        segment1.setDistanceInMeters(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        CompletedSegment segment2 = new CompletedSegment();
        segment2.setName("Main part");
        segment2.setDurationInSeconds(1800L);
        segment2.setDistanceInMeters(3000L);
        segment2.setAverageHeartRate(120L);
        segment2.setTraining(training);

        CompletedSegment segment3 = new CompletedSegment();
        segment3.setName("Cool-down");
        segment3.setDurationInSeconds(600L);
        segment3.setDistanceInMeters(1000L);
        segment3.setAverageHeartRate(100L);
        segment3.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3));

        return training;
    }

    private Training createTraining4() {
        CompletedTraining training = new CompletedTraining();
        training.setTrainingType(TrainingType.INTERVAL);
        training.setDate(LocalDate.of(2025, 1, 5));
        training.setComment("Interval training 10.01.2025");

        CompletedSegment segment1 = new CompletedSegment();
        segment1.setName("Warm-up");
        segment1.setDurationInSeconds(600L);
        segment1.setDistanceInMeters(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        //Interwały - 10 minut rozgrzewki, 8 x 1 min sprintu z 1 min przerwy na trucht, 10 minut schłodzenia
        CompletedSegment segment2 = new CompletedSegment();
        segment2.setName("Sprint 1");
        segment2.setDurationInSeconds(60L);
        segment2.setDistanceInMeters(400L);
        segment2.setAverageHeartRate(null);
        segment2.setTraining(training);

        CompletedSegment segment3 = new CompletedSegment();
        segment3.setName("Trucht 1");
        segment3.setDurationInSeconds(60L);
        segment3.setDistanceInMeters(200L);
        segment3.setAverageHeartRate(null);
        segment3.setTraining(training);

        CompletedSegment segment4 = new CompletedSegment();
        segment4.setName("Sprint 2");
        segment4.setDurationInSeconds(60L);
        segment4.setDistanceInMeters(400L);
        segment4.setAverageHeartRate(null);
        segment4.setTraining(training);

        CompletedSegment segment5 = new CompletedSegment();
        segment5.setName("Trucht 2");
        segment5.setDurationInSeconds(60L);
        segment5.setDistanceInMeters(200L);
        segment5.setAverageHeartRate(null);
        segment5.setTraining(training);

        CompletedSegment segment6 = new CompletedSegment();
        segment6.setName("Sprint 3");
        segment6.setDurationInSeconds(60L);
        segment6.setDistanceInMeters(400L);
        segment6.setAverageHeartRate(null);
        segment6.setTraining(training);

        CompletedSegment segment7 = new CompletedSegment();
        segment7.setName("Trucht 3");
        segment7.setDurationInSeconds(60L);
        segment7.setDistanceInMeters(200L);
        segment7.setAverageHeartRate(null);
        segment7.setTraining(training);

        CompletedSegment segment8 = new CompletedSegment();
        segment8.setName("Sprint 4");
        segment8.setDurationInSeconds(60L);
        segment8.setDistanceInMeters(400L);
        segment8.setAverageHeartRate(null);
        segment8.setTraining(training);

        CompletedSegment segment9 = new CompletedSegment();
        segment9.setName("Trucht 4");
        segment9.setDurationInSeconds(60L);
        segment9.setDistanceInMeters(200L);
        segment9.setAverageHeartRate(null);
        segment9.setTraining(training);

        CompletedSegment segment10 = new CompletedSegment();
        segment10.setName("Cool-down");
        segment10.setDurationInSeconds(600L);
        segment10.setDistanceInMeters(1000L);
        segment10.setAverageHeartRate(100L);
        segment10.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3, segment4, segment5, segment6, segment7, segment8, segment9, segment10));

        return training;
    }

    private Training createTraining5() {
        CompletedTraining training = new CompletedTraining();
        training.setTrainingType(TrainingType.THRESHOLD);
        training.setDate(LocalDate.of(2025, 1, 6));
        training.setComment("Threshold training 10.01.2025");

        CompletedSegment segment1 = new CompletedSegment();
        segment1.setName("Warm-up");
        segment1.setDurationInSeconds(600L);
        segment1.setDistanceInMeters(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        //Progowe - 10 minut rozgrzewki, 20 minut biegu w tempie progowym, 10 minut schłodzenia
        CompletedSegment segment2 = new CompletedSegment();
        segment2.setName("Main part");
        segment2.setDurationInSeconds(1200L);
        segment2.setDistanceInMeters(2000L);
        segment2.setAverageHeartRate(150L);
        segment2.setTraining(training);

        CompletedSegment segment3 = new CompletedSegment();
        segment3.setName("Cool-down");
        segment3.setDurationInSeconds(600L);
        segment3.setDistanceInMeters(1000L);
        segment3.setAverageHeartRate(100L);
        segment3.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3));

        return training;
    }

    private PlannedTraining createPlannedTraining() {
        PlannedTraining training = new PlannedTraining();
        training.setTrainingType(TrainingType.LONG);
        training.setDate(LocalDate.of(2025, 1, 1));
        training.setComment("First training in 2025");

        PlannedTimeSegment segment1 = new PlannedTimeSegment();
        segment1.setName("Warm-up");
        segment1.setPlannedDurationInSeconds(600L);
        segment1.setTraining(training);

        PlannedDistanceSegment segment2 = new PlannedDistanceSegment();
        segment2.setName("Main part");
        segment2.setPlannedDistanceInMeters(3000L);
        segment2.setPlannedPaceInSecondsPerKm(360);
        segment2.setTraining(training);

        PlannedDistanceSegment segment3 = new PlannedDistanceSegment();
        segment3.setName("Cool-down");
        segment3.setPlannedDistanceInMeters(1000L);
        segment3.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3));

        return training;
    }

    @Override
    public void run(String... args) throws Exception {
//        trainingRepository.save(createTraining1());
//        trainingRepository.save(createTraining2());
//        trainingRepository.save(createTraining3());
//        trainingRepository.save(createTraining4());
//        trainingRepository.save(createTraining5());
//        trainingRepository.save(createPlannedTraining());
    }
}
