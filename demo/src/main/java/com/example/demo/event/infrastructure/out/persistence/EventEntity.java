package com.example.demo.event.infrastructure.out.persistence;

import java.time.LocalDateTime;

import com.example.demo.common.infrastructure.BaseLongEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="event")
public class EventEntity extends BaseLongEntity{

    @Column(name="date_time" ,nullable = false)    
    private LocalDateTime dateTime;
    
    @Column(name="organizer_id" ,nullable = false)
    private Long organizerId;
    
    @Column(name="signs" ,nullable = true)
    private Long signs;
    
    @Column(name="event_type_id" ,nullable = true)
    private Integer eventTypeId;
    
    @Column(name="location_id" ,nullable = false)
    private Long locationId;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public Long getSigns() {
        return signs;
    }

    public void setSigns(Long signs) {
        this.signs = signs;
    }

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
        result = prime * result + ((organizerId == null) ? 0 : organizerId.hashCode());
        result = prime * result + ((signs == null) ? 0 : signs.hashCode());
        result = prime * result + ((eventTypeId == null) ? 0 : eventTypeId.hashCode());
        result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EventEntity other = (EventEntity) obj;
        if (dateTime == null) {
            if (other.dateTime != null)
                return false;
        } else if (!dateTime.equals(other.dateTime))
            return false;
        if (organizerId == null) {
            if (other.organizerId != null)
                return false;
        } else if (!organizerId.equals(other.organizerId))
            return false;
        if (signs == null) {
            if (other.signs != null)
                return false;
        } else if (!signs.equals(other.signs))
            return false;
        if (eventTypeId == null) {
            if (other.eventTypeId != null)
                return false;
        } else if (!eventTypeId.equals(other.eventTypeId))
            return false;
        if (locationId == null) {
            if (other.locationId != null)
                return false;
        } else if (!locationId.equals(other.locationId))
            return false;
        return true;
    }

    
    
}
