package com.example.demo.event.domain;

import java.time.LocalDateTime;

import com.example.demo.common.domain.BaseLongDomain;
import com.example.demo.location_related.location.domain.Location;
import com.example.demo.organizer.domain.Organizer;

public class Event extends BaseLongDomain {

    private LocalDateTime dateTime;

    private Long organizerId;
    private Long locationId;
    private Integer eventTypeId;

    private Integer signs;

    // Relaciones opcionales (NO obligatorias)
    private Organizer organizer;
    private Location location;

    private Event(Builder builder) {
        this.id = builder.id;
        this.dateTime = builder.dateTime;
        this.organizerId = builder.organizerId;
        this.locationId = builder.locationId;
        this.signs = builder.signs;
        this.organizer = builder.organizer;
        this.eventTypeId = builder.eventTypeId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Integer getSigns() {
        return signs;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setSigns(Integer signs) {
        this.signs = signs;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Event withOrganizer(Organizer organizer) {
        this.organizer = organizer;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public Event withLocation(Location location) {
        this.location = location;
        return this;
    }

    public static class Builder {
        private Long id;
        private LocalDateTime dateTime;
        private Long organizerId;
        private Long locationId;
        private Integer signs = 0;
        private Organizer organizer;
        private Integer eventTypeId = 1;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder organizerId(Long organizerId) {
            this.organizerId = organizerId;
            return this;
        }

        public Builder locationId(Long locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder signs(Integer signs) {
            this.signs = signs;
            return this;
        }

        public Builder organizer(Organizer organizer) {
            this.organizer = organizer;
            return this;
        }
        
        public Builder eventTypeId(Integer eventTypeId) {
            this.eventTypeId = eventTypeId;
            return this;
        }

        public Event build() {
            // 🔒 Validaciones de dominio
            if (dateTime == null) {
                throw new IllegalStateException("dateTime is mandatory");
            }
            if (organizerId == null) {
                throw new IllegalStateException("organizerId is mandatory");
            }
            return new Event(this);
        }
    }
}
