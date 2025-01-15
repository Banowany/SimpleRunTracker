export interface PlannedSegmentDTO {
    // id: number;
    name?: string;
    plannedPaceInSecondsPerKm?: number;
    plannedDurationInSeconds?: number;
    plannedDistanceInMeters?: number;
    planned_segment_type: string;
}