package com.example.demo.day_description.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.example.demo.day_description.domain.DayDescription;


public interface GetDayDescriptionUseCase {

    List<DayDescription> getAllDescriptions();
    
    Optional<DayDescription> getDayDescriptionById(Long id);

    Optional<DayDescription> getDayDescriptionForEvent(Long id);

    Optional<DayDescription> getDayDescriptionByEventId(Long eventId);
}
