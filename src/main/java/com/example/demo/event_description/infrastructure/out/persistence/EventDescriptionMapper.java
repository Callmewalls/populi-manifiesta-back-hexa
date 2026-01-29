package com.example.demo.event_description.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.event_description.domain.EventDescription;

@Mapper(componentModel="spring")
public interface EventDescriptionMapper{
    
    EventDescriptionEntity toEntity(EventDescription eventDescription);

    EventDescription toDomain(EventDescriptionEntity entity);
}
