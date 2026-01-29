package com.example.demo.location_related.location.application.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.event.application.ports.out.EventRepositoryPort;
import com.example.demo.event.domain.Event;
import com.example.demo.location_related.location.application.ports.in.GetLocationUseCase;
import com.example.demo.location_related.location.application.ports.in.PostLocationUseCase;
import com.example.demo.location_related.location.application.ports.out.LocationRepositoryPort;
import com.example.demo.location_related.location.domain.Location;

@Service
public class LocationService implements GetLocationUseCase, PostLocationUseCase {

    private final LocationRepositoryPort locationRepositoryPort;
    private final EventRepositoryPort eventRepositoryPort;

    public LocationService(LocationRepositoryPort locationRepositoryPort, EventRepositoryPort eventRepositoryPort) {
        this.locationRepositoryPort = locationRepositoryPort;
        this.eventRepositoryPort = eventRepositoryPort;
    }

    @Override
    public Location getLocationById(Long locationId) {
        return locationRepositoryPort.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }

    @Override
    public List<Location> getAll() {
        return locationRepositoryPort.getAll();
    }

    @Override
    public List<Location> findByIds(List<Long> ids) {
        return locationRepositoryPort.findByIds(ids);
    }

    @Override
    public Map<Long, Location> getLocationsForDate(LocalDate date) {
        List<Event> events = eventRepositoryPort.findEventsForDate(date);

        // Recogemos todos los locationIds
        List<Long> locationIds = events.stream()
                .map(Event::getLocationId)
                .distinct()
                .toList();

        Map<Long, Location> locationsMap = locationRepositoryPort.findByIds(locationIds)
                .stream()
                .collect(Collectors.toMap(Location::getId, Function.identity()));

        // Enriquecemos los eventos
        return locationsMap;
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepositoryPort.save(location);
    }
}
