import {SegmentDTO} from "./segment.dto";

export interface TrainingDTO {
    id: number
    trainingType: string
    date: string //yyyy-mm-dd
    comment: string
    segments: SegmentDTO[]
}