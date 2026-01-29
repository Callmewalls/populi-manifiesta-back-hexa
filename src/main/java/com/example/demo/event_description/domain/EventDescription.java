package com.example.demo.event_description.domain;

import com.example.demo.common.domain.BaseLongDomain;
import com.example.demo.event.domain.Event;

public class EventDescription extends BaseLongDomain{

    private String imageUrl;
    private Integer eventId;
    private String objectivesText;
    private String eventName;
    private String locationSrc;
    private String eventDescription;

    private Event event;

    public EventDescription(String imageUrl, Integer eventId, String objectivesText, String eventName,
            String locationSrc, String eventDescription, Event event) {
        this.imageUrl = imageUrl;
        this.eventId = eventId;
        this.objectivesText = objectivesText;
        this.eventName = eventName;
        this.locationSrc = locationSrc;
        this.eventDescription = eventDescription;
        this.event = event;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Integer getEventId() {
        return eventId;
    }
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
    public String getObjectivesText() {
        return objectivesText;
    }
    public void setObjectivesText(String objectivesText) {
        this.objectivesText = objectivesText;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getLocationSrc() {
        return locationSrc;
    }
    public void setLocationSrc(String locationSrc) {
        this.locationSrc = locationSrc;
    }
    public String getEventDescription() {
        return eventDescription;
    }
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Event getEvent() {
        return event;
    }

    public EventDescription setEvent(Event event) {
        this.event = event;
        return this;
    }
    
}
