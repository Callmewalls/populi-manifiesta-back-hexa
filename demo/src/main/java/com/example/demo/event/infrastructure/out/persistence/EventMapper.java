package com.example.demo.event.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.event.domain.Event;


@Mapper(componentModel="spring")
public interface EventMapper{
    
    EventEntity toEntity(Event event);

    Event toDomain(EventEntity entity);
}
