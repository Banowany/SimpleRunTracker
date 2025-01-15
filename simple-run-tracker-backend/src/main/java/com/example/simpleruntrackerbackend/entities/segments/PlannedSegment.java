package com.example.simpleruntrackerbackend.entities.segments;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "planned_segment_type")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "planned_segment_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(
                value = PlannedTimeSegment.class,
                name = "time"
        ),
        @JsonSubTypes.Type(
                value = PlannedDistanceSegment.class,
                name = "distance"
        )
})
public class PlannedSegment extends Segment {
    private Integer plannedPaceInSecondsPerKm;

    public Integer getPlannedPaceInSecondsPerKm() {
        return plannedPaceInSecondsPerKm;
    }

    public void setPlannedPaceInSecondsPerKm(Integer plannedPaceInSecondsPerKm) {
        this.plannedPaceInSecondsPerKm = plannedPaceInSecondsPerKm;
    }
}
