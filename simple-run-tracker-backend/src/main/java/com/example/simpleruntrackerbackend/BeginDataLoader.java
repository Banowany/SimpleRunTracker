package com.example.simpleruntrackerbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BeginDataLoader implements CommandLineRunner {
    private final TrainingRepository trainingRepository;
    public BeginDataLoader(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    private Training createTraining1() {
        Training training = new Training();
        training.setTrainingType(TrainingType.LONG);
        training.setDateTime(LocalDateTime.of(2025, 1, 1, 0, 0));
        training.setComment("First training in 2025");

        Segment segment1 = new Segment();
        segment1.setName("Warm-up");
        segment1.setDuration(600L);
        segment1.setDistance(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        Segment segment2 = new Segment();
        segment2.setName("Main part");
        segment2.setDuration(1800L);
        segment2.setDistance(3000L);
        segment2.setAverageHeartRate(120L);
        segment2.setTraining(training);

        Segment segment3 = new Segment();
        segment3.setName("Cool-down");
        segment3.setDuration(600L);
        segment3.setDistance(1000L);
        segment3.setAverageHeartRate(100L);
        segment3.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3));

        return training;
    }

    private Training createTraining2() {
        Training training = new Training();
        training.setTrainingType(TrainingType.SPEED);
        training.setDateTime(LocalDateTime.of(2025, 1, 3, 0, 0));
        training.setComment("Second training in 2025 - speed training");

        Segment segment1 = new Segment();
        segment1.setName("Warm-up");
        segment1.setDuration(600L);
        segment1.setDistance(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        Segment segment2 = new Segment();
        segment2.setName("Main part");
        segment2.setDuration(1800L);
        segment2.setDistance(3000L);
        segment2.setAverageHeartRate(120L);
        segment2.setTraining(training);

        //jogs segments 4x100m/100m
        Segment segment3 = new Segment();
        segment3.setName("Fast jog 100m 1");
        segment3.setDuration(30L);
        segment3.setDistance(100L);
        segment3.setAverageHeartRate(null);
        segment3.setTraining(training);

        Segment segment4 = new Segment();
        segment4.setName("Slow jog 100m 1");
        segment4.setDuration(60L);
        segment4.setDistance(100L);
        segment4.setAverageHeartRate(null);
        segment4.setTraining(training);

        Segment segment5 = new Segment();
        segment5.setName("Fast jog 100m 2");
        segment5.setDuration(30L);
        segment5.setDistance(100L);
        segment5.setAverageHeartRate(null);
        segment5.setTraining(training);

        Segment segment6 = new Segment();
        segment6.setName("Slow jog 100m 2");
        segment6.setDuration(60L);
        segment6.setDistance(100L);
        segment6.setAverageHeartRate(null);
        segment6.setTraining(training);

        Segment segment7 = new Segment();
        segment7.setName("Fast jog 100m 3");
        segment7.setDuration(30L);
        segment7.setDistance(100L);
        segment7.setAverageHeartRate(null);
        segment7.setTraining(training);

        Segment segment8 = new Segment();
        segment8.setName("Slow jog 100m 3");
        segment8.setDuration(60L);
        segment8.setDistance(100L);
        segment8.setAverageHeartRate(null);
        segment8.setTraining(training);

        Segment segment9 = new Segment();
        segment9.setName("Fast jog 100m 4");
        segment9.setDuration(30L);
        segment9.setDistance(100L);
        segment9.setAverageHeartRate(null);
        segment9.setTraining(training);

        Segment segment10 = new Segment();
        segment10.setName("Slow jog 100m 4");
        segment10.setDuration(60L);
        segment10.setDistance(100L);
        segment10.setAverageHeartRate(null);
        segment10.setTraining(training);

        Segment segment11 = new Segment();
        segment11.setName("Cool-down");
        segment11.setDistance(1000L);
        segment11.setDuration(600L);
        segment11.setAverageHeartRate(100L);
        segment11.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3, segment4, segment5, segment6, segment7, segment8, segment9, segment10, segment11));

        return training;
    }

    private Training createTraining3() {
        Training training = new Training();
        training.setTrainingType(TrainingType.LONG);
        training.setDateTime(LocalDateTime.of(2025, 1, 4, 0, 0));
        training.setComment("Easy run 10.01.2025");

        Segment segment1 = new Segment();
        segment1.setName("Warm-up");
        segment1.setDuration(600L);
        segment1.setDistance(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        Segment segment2 = new Segment();
        segment2.setName("Main part");
        segment2.setDuration(1800L);
        segment2.setDistance(3000L);
        segment2.setAverageHeartRate(120L);
        segment2.setTraining(training);

        Segment segment3 = new Segment();
        segment3.setName("Cool-down");
        segment3.setDuration(600L);
        segment3.setDistance(1000L);
        segment3.setAverageHeartRate(100L);
        segment3.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3));

        return training;
    }

    private Training createTraining4() {
        Training training = new Training();
        training.setTrainingType(TrainingType.INTERVAL);
        training.setDateTime(LocalDateTime.of(2025, 1, 5, 0, 0));
        training.setComment("Interval training 10.01.2025");

        Segment segment1 = new Segment();
        segment1.setName("Warm-up");
        segment1.setDuration(600L);
        segment1.setDistance(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        //Interwały - 10 minut rozgrzewki, 8 x 1 min sprintu z 1 min przerwy na trucht, 10 minut schłodzenia
        Segment segment2 = new Segment();
        segment2.setName("Sprint 1");
        segment2.setDuration(60L);
        segment2.setDistance(400L);
        segment2.setAverageHeartRate(null);
        segment2.setTraining(training);

        Segment segment3 = new Segment();
        segment3.setName("Trucht 1");
        segment3.setDuration(60L);
        segment3.setDistance(200L);
        segment3.setAverageHeartRate(null);
        segment3.setTraining(training);

        Segment segment4 = new Segment();
        segment4.setName("Sprint 2");
        segment4.setDuration(60L);
        segment4.setDistance(400L);
        segment4.setAverageHeartRate(null);
        segment4.setTraining(training);

        Segment segment5 = new Segment();
        segment5.setName("Trucht 2");
        segment5.setDuration(60L);
        segment5.setDistance(200L);
        segment5.setAverageHeartRate(null);
        segment5.setTraining(training);

        Segment segment6 = new Segment();
        segment6.setName("Sprint 3");
        segment6.setDuration(60L);
        segment6.setDistance(400L);
        segment6.setAverageHeartRate(null);
        segment6.setTraining(training);

        Segment segment7 = new Segment();
        segment7.setName("Trucht 3");
        segment7.setDuration(60L);
        segment7.setDistance(200L);
        segment7.setAverageHeartRate(null);
        segment7.setTraining(training);

        Segment segment8 = new Segment();
        segment8.setName("Sprint 4");
        segment8.setDuration(60L);
        segment8.setDistance(400L);
        segment8.setAverageHeartRate(null);
        segment8.setTraining(training);

        Segment segment9 = new Segment();
        segment9.setName("Trucht 4");
        segment9.setDuration(60L);
        segment9.setDistance(200L);
        segment9.setAverageHeartRate(null);
        segment9.setTraining(training);

        Segment segment10 = new Segment();
        segment10.setName("Cool-down");
        segment10.setDuration(600L);
        segment10.setDistance(1000L);
        segment10.setAverageHeartRate(100L);
        segment10.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3, segment4, segment5, segment6, segment7, segment8, segment9, segment10));

        return training;
    }

    private Training createTraining5() {
        Training training = new Training();
        training.setTrainingType(TrainingType.THRESHOLD);
        training.setDateTime(LocalDateTime.of(2025, 1, 6, 0, 0));
        training.setComment("Threshold training 10.01.2025");

        Segment segment1 = new Segment();
        segment1.setName("Warm-up");
        segment1.setDuration(600L);
        segment1.setDistance(1000L);
        segment1.setAverageHeartRate(100L);
        segment1.setTraining(training);

        //Progowe - 10 minut rozgrzewki, 20 minut biegu w tempie progowym, 10 minut schłodzenia
        Segment segment2 = new Segment();
        segment2.setName("Main part");
        segment2.setDuration(1200L);
        segment2.setDistance(2000L);
        segment2.setAverageHeartRate(150L);
        segment2.setTraining(training);

        Segment segment3 = new Segment();
        segment3.setName("Cool-down");
        segment3.setDuration(600L);
        segment3.setDistance(1000L);
        segment3.setAverageHeartRate(100L);
        segment3.setTraining(training);

        training.setSegments(List.of(segment1, segment2, segment3));

        return training;
    }

    @Override
    public void run(String... args) throws Exception {
        trainingRepository.save(createTraining1());
        trainingRepository.save(createTraining2());
        trainingRepository.save(createTraining3());
        trainingRepository.save(createTraining4());
        trainingRepository.save(createTraining5()); 
    }
}
