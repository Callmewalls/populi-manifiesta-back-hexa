package com.example.demo.day_description.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.day_description.application.ports.in.GetDayDescriptionUseCase;
import com.example.demo.day_description.application.ports.out.DayDescriptionRepositoryPort;
import com.example.demo.day_description.domain.DayDescription;
import com.example.demo.event.application.ports.out.EventRepositoryPort;
import com.example.demo.event.domain.Event;
import com.example.demo.organizer.application.ports.out.OrganizerRepositoryPort;
import com.example.demo.organizer.domain.Organizer;

@Service
public class DayDescriptionService implements GetDayDescriptionUseCase {

    private final DayDescriptionRepositoryPort dayDescriptionRepositoryPort;
    private final EventRepositoryPort eventRepositoryPort;
    private final OrganizerRepositoryPort organizerRepositoryPort;

    public DayDescriptionService(DayDescriptionRepositoryPort dayDescriptionRepositoryPort,
            EventRepositoryPort eventRepositoryPort,
            OrganizerRepositoryPort organizerRepositoryPort) {
        this.dayDescriptionRepositoryPort = dayDescriptionRepositoryPort;
        this.eventRepositoryPort = eventRepositoryPort;
        this.organizerRepositoryPort = organizerRepositoryPort;
    }

    @Override
    public Optional<DayDescription> getDayDescriptionById(Long dayDescriptionId) {
        return dayDescriptionRepositoryPort.findById(dayDescriptionId);
    }

    @Override
    public Optional<DayDescription> getDayDescriptionByEventId(Long eventId) {
        return dayDescriptionRepositoryPort.findByEventId(eventId)
                .map(dd -> {
                    Optional<Event> eventOpt = eventRepositoryPort.findById(eventId);

                    Event enrichedEvent = eventOpt.map(event -> {
                        Organizer organizer = event.getOrganizerId() != null
                                ? organizerRepositoryPort.findById(event.getOrganizerId()).orElse(null)
                                : null;

                        return event.withOrganizer(organizer);
                    }).orElse(null);

                    return dd.withEvent(enrichedEvent); // withEvent devuelve copia con event asignado
                });
    }

    @Override
    public List<DayDescription> getAllDescriptions() {
        return dayDescriptionRepositoryPort.findAll();
    }

    @Override
    public Optional<DayDescription> getDayDescriptionForEvent(Long id) {
        return dayDescriptionRepositoryPort.findByEventId(id);
    }

}