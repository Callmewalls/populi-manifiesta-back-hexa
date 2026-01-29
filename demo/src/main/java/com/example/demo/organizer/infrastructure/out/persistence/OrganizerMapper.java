package com.example.demo.organizer.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.organizer.domain.Organizer;


@Mapper(componentModel="spring")
public interface OrganizerMapper{
    
    OrganizerEntity toEntity(Organizer organizer);

    Organizer toOrganizer(OrganizerEntity entity);
}
