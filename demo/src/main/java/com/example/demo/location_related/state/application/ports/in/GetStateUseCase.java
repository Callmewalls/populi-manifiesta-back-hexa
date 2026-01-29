package com.example.demo.location_related.state.application.ports.in;

import java.util.List;

import com.example.demo.location_related.state.domain.State;


public interface GetStateUseCase {
    
    State getStateById(Long stateId);

    List<State> getAll();
}
