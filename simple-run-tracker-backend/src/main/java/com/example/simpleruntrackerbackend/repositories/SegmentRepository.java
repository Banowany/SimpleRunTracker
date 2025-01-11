package com.example.simpleruntrackerbackend.repositories;

import com.example.simpleruntrackerbackend.entities.segments.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentRepository extends JpaRepository<Segment, Long> {
    
}
