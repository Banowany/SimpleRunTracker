import {TrainingDTO} from "./training.dto";

export interface TrainingSummaryDto {
    totalTrainingCount: number;
    totalDuration: number;
    totalDistance: number;
    trainings: TrainingDTO[];
}