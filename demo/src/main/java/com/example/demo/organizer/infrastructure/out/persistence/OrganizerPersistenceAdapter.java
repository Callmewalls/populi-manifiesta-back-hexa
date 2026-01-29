package com.example.demo.organizer.infrastructure.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.organizer.application.ports.out.OrganizerRepositoryPort;
import com.example.demo.organizer.domain.Organizer;

@Component
public class OrganizerPersistenceAdapter implements OrganizerRepositoryPort{

    JpaOrganizerRepository repository;
    OrganizerMapper mapper;

    public OrganizerPersistenceAdapter(JpaOrganizerRepository repository, OrganizerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    
    @Override
    public Optional<Organizer> findById(Long organizerId) {
        return repository.findById(organizerId).map(mapper::toOrganizer);
    }

    @Override
    public List<Organizer> findAll() {
        return repository.findAll().stream().map(mapper::toOrganizer).toList();
    }

    @Override
    public List<Organizer> findByIds(List<Long> organizereIds) {
        return repository.findByIds(organizereIds).stream().map(mapper::toOrganizer).toList();
    }
    
}
