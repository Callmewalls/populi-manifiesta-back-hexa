package com.example.demo.day_description.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.demo.day_description.domain.DayDescription;


public interface DayDescriptionRepositoryPort {
    
    Optional<DayDescription> findById(Long daydescriptionId);
    
    Optional<DayDescription> findByEventId(Long eventsId);
    
    List<DayDescription> findAll();
}
