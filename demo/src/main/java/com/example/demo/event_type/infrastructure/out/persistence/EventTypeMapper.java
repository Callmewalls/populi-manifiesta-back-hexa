package com.example.demo.event_type.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.event_type.domain.EventType;


@Mapper(componentModel="spring")
public interface EventTypeMapper{
    
    EventTypeEntity toEntity(EventType eventtype);

    EventType toEventType(EventTypeEntity entity);
}
