import {PlannedTrainingDTO} from "../dtos/plannedTraining.dto";

class PlannedTrainingService {
    mapToCalendarEvent(plannedTraining: PlannedTrainingDTO) {
        return {
            title: plannedTraining.trainingType,
            start: new Date(plannedTraining.date),
            end: new Date(plannedTraining.date),
            training: plannedTraining,
            //set purple color for planned training
            // style: { backgroundColor: 'purple' }
            color: 'purple',
            isPlanned: true
        }
    }

    mapToCalendarEvents(plannedTrainings: PlannedTrainingDTO[]) {
        return plannedTrainings.map(plannedTraining => this.mapToCalendarEvent(plannedTraining))
    }
}

export default PlannedTrainingService;