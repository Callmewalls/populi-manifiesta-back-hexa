package com.example.demo.event.infrastructure.in.web;

public record EventRequest (
    String dateTime,
    Long cityId
){}
