package com.example.demo.day_description.infrastructure.out.persistence;

import java.io.Serializable;

import com.example.demo.common.infrastructure.BaseLongEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "day_description")
public class DayDescriptionEntity extends BaseLongEntity implements Serializable {

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "image_url", length = 100)
    private String imageUrl;

    @Column(name = "event_id")
    private Long eventId;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "event_id", referencedColumnName = "id")
    // private EventEntity event;

    // Constructor vacío
    public DayDescriptionEntity() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    // Constructor con campos opcional
    public DayDescriptionEntity(String description, String imageUrl
        // ,EventEntity event
    ) {
        this.description = description;
        this.imageUrl = imageUrl;
        // this.event = event;
    }

    // Getters y Setters

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

    // public EventEntity getEvent() {
    //     return event;
    // }

    // public void setEvent(EventEntity event) {
    //     this.event = event;
    // }
}
