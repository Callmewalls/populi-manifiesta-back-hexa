package com.example.demo.location_related.state.infrastructure.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.location_related.state.application.ports.out.StateRepositoryPort;
import com.example.demo.location_related.state.domain.State;


@Component
public class StatePersistenceAdapter implements StateRepositoryPort{

    JpaStateRepository repository;
    StateMapper mapper;

    public StatePersistenceAdapter(JpaStateRepository repository, StateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<State> findById(Long stateId) {
        return repository.findById(stateId).map(mapper::toState);
    }

    @Override
    public List<State> findAll() {
        return repository.findAll().stream().map(mapper::toState).toList();
    }
    
}
