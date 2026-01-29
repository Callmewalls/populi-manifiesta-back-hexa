package com.example.demo.location_related.state.infrastructure.in.web;

import org.mapstruct.Mapper;

import com.example.demo.location_related.state.domain.State;

@Mapper(componentModel = "spring")
public interface StateWebMapper {
    
    StateResponse toResponse(State state);
}
