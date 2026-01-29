package com.example.demo.organizer.infrastructure.in.web;

import org.mapstruct.Mapper;

import com.example.demo.organizer.domain.Organizer;


@Mapper(componentModel = "spring")
public interface OrganizerWebMapper {
    
    OrganizerResponse toResponse(Organizer organizer);
}
