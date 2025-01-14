import {PlannedSegmentDTO} from "./plannedSegment.dto";

export interface PlannedTrainingDTO {
    id: number;
    trainingType: string;
    date: string;
    comment: string;
    plannedSegments: PlannedSegmentDTO[];
}