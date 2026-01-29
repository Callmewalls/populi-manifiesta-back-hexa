package com.example.demo.location_related.state.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.location_related.state.domain.State;


@Mapper(componentModel="spring")
public interface StateMapper{
    
    StateEntity toEntity(State state);

    State toState(StateEntity entity);
}
