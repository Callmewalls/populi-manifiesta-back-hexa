package com.example.demo.day_description.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.day_description.domain.DayDescription;


@Mapper(componentModel="spring")
public interface DayDescriptionMapper{
    
    DayDescriptionEntity toEntity(DayDescription dayDescription);

    DayDescription toDomain(DayDescriptionEntity entity);
}
