package com.example.demo.day_description.infrastructure.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.day_description.application.ports.out.DayDescriptionRepositoryPort;
import com.example.demo.day_description.domain.DayDescription;


@Component
public class DayDescriptionPersistenceAdapter implements DayDescriptionRepositoryPort{

    JpaDayDescriptionRepository repository;
    DayDescriptionMapper mapper;

    public DayDescriptionPersistenceAdapter(JpaDayDescriptionRepository repository, DayDescriptionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DayDescription> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<DayDescription> findByEventId(Long eventId) {
        return repository.findByEventId(eventId)
                .map(mapper::toDomain);
    }

    @Override
    public List<DayDescription> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
    
}
