package com.example.demo.location_related.state.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location_related.state.application.ports.in.GetStateUseCase;
import com.example.demo.location_related.state.application.ports.out.StateRepositoryPort;
import com.example.demo.location_related.state.domain.State;


@Service
public class StateService implements GetStateUseCase {

    private final StateRepositoryPort stateRepositoryPort;

    public StateService(StateRepositoryPort stateRepositoryPort) {
        this.stateRepositoryPort = stateRepositoryPort;
    }

    @Override
    public State getStateById(Long stateId) {
        return stateRepositoryPort.findById(stateId)
                .orElseThrow(() -> new RuntimeException("State not found"));
    }

    @Override
    public List<State> getAll() {
        return stateRepositoryPort.findAll();
    }

    
}
