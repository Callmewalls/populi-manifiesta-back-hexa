package com.example.demo.location_related.location.infrastructure.in.web;

public record LocationMapMarkerResponse (
    Long id,
    String name,
    double latitude,
    double longitude
) {}

