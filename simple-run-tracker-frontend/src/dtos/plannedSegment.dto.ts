export interface PlannedSegmentDTO {
    id: number;
    name: string;
    plannedPaceInSecondsPerKm: number;
    durationInSeconds?: number;
    distanceInMeters?: number;
    planned_segment_type: string;
}