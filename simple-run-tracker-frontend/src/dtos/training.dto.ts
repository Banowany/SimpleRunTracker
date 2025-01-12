import {SegmentDTO} from "./segment.dto";

export interface TrainingDTO {
    id: number
    training_type: string
    date: string //yyyy-mm-dd
    comment: string
    segments: SegmentDTO[]
}