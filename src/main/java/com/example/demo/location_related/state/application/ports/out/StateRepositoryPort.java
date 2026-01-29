package com.example.demo.location_related.state.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.demo.location_related.state.domain.State;


public interface StateRepositoryPort {
    
    Optional<State> findById(Long stateId);
    
    List<State> findAll();
}
