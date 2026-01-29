package com.example.demo.event_description.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.event.application.ports.out.EventRepositoryPort;
import com.example.demo.event.domain.Event;
import com.example.demo.event_description.application.ports.in.GetEventDescriptionUseCase;
import com.example.demo.event_description.application.ports.out.EventDescriptionRepositoryPort;
import com.example.demo.event_description.domain.EventDescription;
import com.example.demo.organizer.application.ports.out.OrganizerRepositoryPort;
import com.example.demo.organizer.domain.Organizer;

@Service
public class EventDescriptionService implements GetEventDescriptionUseCase {

    private final EventDescriptionRepositoryPort eventDescriptionRepositoryPort;
    private final EventRepositoryPort eventRepositoryPort;
    private final OrganizerRepositoryPort organizerRepositoryPort;

    public EventDescriptionService(
            EventDescriptionRepositoryPort eventDescriptionRepositoryPort,
            EventRepositoryPort eventRepositoryPort,
            OrganizerRepositoryPort organizerRepositoryPort) {
        this.eventDescriptionRepositoryPort = eventDescriptionRepositoryPort;
        this.eventRepositoryPort = eventRepositoryPort;
        this.organizerRepositoryPort = organizerRepositoryPort;
    }

    @Override
    public Optional<EventDescription> getEventDescriptionById(Long eventDescriptionId) {
        return eventDescriptionRepositoryPort.findById(eventDescriptionId);
    }

    @Override
    public Optional<EventDescription> getEventDescriptionByEventId(Long eventId) {
        Optional<EventDescription> edd = eventDescriptionRepositoryPort.findByEventId(eventId)
                .map(ed -> {
                    // Trae el evento asociado
                    Optional<Event> eventOpt = eventRepositoryPort.findById(eventId);

                    Event enrichedEvent = eventOpt.map(event -> {
                        // Enriquecer con Organizer solo si existe
                        Organizer organizer = event.getOrganizerId() != null
                                ? organizerRepositoryPort.findById(event.getOrganizerId()).orElse(null)
                                : null;

                        return event.withOrganizer(organizer);
                    }).orElse(null);

                    // Retorna un EventDescription enriquecido
                    return ed.setEvent(enrichedEvent); // withEvent devuelve copia con event asignado
                });
        return edd;
    }

    @Override
    public List<EventDescription> getAllEventDescription() {
        return eventDescriptionRepositoryPort.findAll();
    }

}
