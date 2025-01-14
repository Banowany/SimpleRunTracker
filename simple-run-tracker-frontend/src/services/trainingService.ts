import {TrainingDTO} from "../dtos/training.dto";

class TrainingService {
    mapToCalendarEvents(trainings: TrainingDTO[]) {
        return trainings.map(training => ({
            title: training.trainingType,
            start: training.date,
            end: training.date,
            training: training,
            color: 'green'
        }))
    }

    mapToCalendarEvent(training: TrainingDTO) {
        return {
            title: training.trainingType,
            start: training.date,
            end: training.date,
            training: training,
            color: 'green'
        }
    }
}

export default TrainingService