package com.example.demo.day_description.infrastructure.in.web;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.day_description.domain.DayDescription;
import com.example.demo.event.infrastructure.in.web.EventWebMapper;

@Mapper(componentModel = "spring")
public abstract class DayDescriptionWebMapper {
    
    @Autowired
    protected EventWebMapper eventWebMapper;
    
    public DayDescriptionResponse toResponse(DayDescription dayDescription) {
        return new DayDescriptionResponse(
                dayDescription.getId(),
                dayDescription.getDescription(),
                dayDescription.getImageUrl(),
                dayDescription.getEventId(),
                eventWebMapper.toResponse(dayDescription.getEvent())
        );
    }
}
