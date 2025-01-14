import {TrainingDTO} from "../dtos/training.dto";

class TrainingService {
    mapToCalendarEvents(trainings: TrainingDTO[]) {
        return trainings.map(training => ({
            title: training.trainingType,
            start: new Date(training.date),
            end: new Date(training.date),
            training: training,
            color: 'green',
            isPlanned: false
        }))
    }

    mapToCalendarEvent(training: TrainingDTO) {
        return {
            title: training.trainingType,
            start: new Date(training.date),
            end: new Date(training.date),
            training: training,
            color: 'green',
            isPlanned: false
        }
    }
}

export default TrainingService