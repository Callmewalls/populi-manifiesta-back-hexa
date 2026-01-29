package com.example.demo.organizer.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.demo.organizer.domain.Organizer;

public interface OrganizerRepositoryPort {
    
    Optional<Organizer> findById(Long organizerId);
    
    List<Organizer> findAll();

    List<Organizer> findByIds(List<Long> organizereIds);
}
