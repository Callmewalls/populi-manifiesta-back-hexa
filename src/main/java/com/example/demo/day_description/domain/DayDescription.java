package com.example.demo.day_description.domain;

import com.example.demo.common.domain.BaseLongDomain;
import com.example.demo.event.domain.Event;

public class DayDescription extends BaseLongDomain{

    String description;
    String imageUrl;
    Long eventId;
    Event  event;

    public DayDescription(String description, String imageUrl, Long eventId) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.eventId = eventId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Event getEvent() {
        return event;
    }

    public DayDescription withEvent(Event event) {
        this.event = event;
        return this;
    }
    
}
