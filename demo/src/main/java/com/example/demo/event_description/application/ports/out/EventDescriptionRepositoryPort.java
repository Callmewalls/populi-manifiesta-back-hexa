package com.example.demo.event_description.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.demo.event_description.domain.EventDescription;


public interface EventDescriptionRepositoryPort {
    
    List<EventDescription> findAll();
    
    Optional<EventDescription> findById(Long id);
    
    Optional<EventDescription> findByEventId(Long id);
}
