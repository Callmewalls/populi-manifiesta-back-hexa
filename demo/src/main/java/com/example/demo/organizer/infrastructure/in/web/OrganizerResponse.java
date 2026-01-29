package com.example.demo.organizer.infrastructure.in.web;

public record OrganizerResponse(
    Long id,
    String nif,
    String name,
    String last_names,
    String email,
    Integer phone,
    Long location_id,
    String resp_name,
    String resp_nif,
    Integer resp_phone
){}