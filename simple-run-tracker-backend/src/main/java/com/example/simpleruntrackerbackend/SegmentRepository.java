package com.example.simpleruntrackerbackend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentRepository extends JpaRepository<Segment, Long> {
    
}
