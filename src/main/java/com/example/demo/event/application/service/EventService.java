package com.example.demo.event.application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.event.application.ports.in.GetEventUseCase;
import com.example.demo.event.application.ports.in.PostEventUseCase;
import com.example.demo.event.application.ports.out.EventRepositoryPort;
import com.example.demo.event.domain.Event;
import com.example.demo.location_related.city.application.ports.out.CityRepositoryPort;
import com.example.demo.location_related.city.domain.City;
import com.example.demo.location_related.location.application.ports.in.PostLocationUseCase;
import com.example.demo.location_related.location.domain.Location;
import com.example.demo.organizer.application.ports.out.OrganizerRepositoryPort;
import com.example.demo.organizer.domain.Organizer;

@Service
public class EventService implements GetEventUseCase, PostEventUseCase {

    private final EventRepositoryPort eventRepositoryPort;
    private final OrganizerRepositoryPort organizerRepositoryPort;
    private final CityRepositoryPort cityRepositoryPort;
    private final PostLocationUseCase locationUseCase;

    public EventService(
        EventRepositoryPort eventRepositoryPort, 
        OrganizerRepositoryPort organizerRepositoryPort,
        CityRepositoryPort cityRepositoryPort,
        PostLocationUseCase locationUseCase
    ) {
        this.eventRepositoryPort = eventRepositoryPort;
        this.organizerRepositoryPort = organizerRepositoryPort;
        this.cityRepositoryPort = cityRepositoryPort;
        this.locationUseCase = locationUseCase;
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepositoryPort.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<Event> getEventsForDate(LocalDate date) {
        return eventRepositoryPort.findEventsForDate(date);
    }

    @Override
    public List<Event> getEventsOrganizersForDate(LocalDate date) {

        List<Event> events = eventRepositoryPort.findEventsForDate(date);

        // Obtener ids distintos de organizer
        List<Long> organizerIds = events.stream()
                .map(Event::getOrganizerId)
                .distinct()
                .toList();

        // Llamar al persistence adapter y mapear entidades a dominios
        List<Organizer> organizers = organizerRepositoryPort.findByIds(organizerIds);

        // Convertir la lista a un Map<Long, Organizer>
        Map<Long, Organizer> organizersMap = organizers.stream()
                .collect(Collectors.toMap(Organizer::getId, Function.identity()));

        // Enriquecer los eventos
        return events.stream()
                .map(e -> e.withOrganizer(organizersMap.get(e.getOrganizerId())))
                .toList();
    }

    @Override
    public Event createEvent(String dateTime, Long organizerId, Long cityId) {
        City city = cityRepositoryPort.findById(cityId).get();
        
        Location loc = new Location("Address", city.getLatitude(), city.getLongitude(), cityId, "EventLocation");
        Location createdLoc = locationUseCase.createLocation(loc);

        LocalDate ld = LocalDate.parse(dateTime);
        LocalDateTime ldt = LocalDateTime.of(ld, LocalDateTime.MIN.toLocalTime());
        Event event = Event.builder().dateTime(ldt).locationId(createdLoc.getId()).organizerId(organizerId).build();
        Event createdEvent = eventRepositoryPort.createEvent(event);

        return createdEvent;
    }

    @Override
    public List<Event> getEventsByMonth(Integer monthNumber) {
        return eventRepositoryPort.findByMonth(monthNumber);
    }

}
