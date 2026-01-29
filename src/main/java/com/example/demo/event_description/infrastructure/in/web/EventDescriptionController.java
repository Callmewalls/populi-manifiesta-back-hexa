package com.example.demo.event_description.infrastructure.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.event_description.application.ports.in.GetEventDescriptionUseCase;
import com.example.demo.event_description.domain.EventDescription;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "event-descriptions")
public class EventDescriptionController {

    EventDescriptionWebMapper mapper;
    GetEventDescriptionUseCase getCase;

    public EventDescriptionController(EventDescriptionWebMapper mapper, GetEventDescriptionUseCase getCase) {
        this.mapper = mapper;
        this.getCase = getCase;
    }

    @GetMapping("/getAll")
    public List<EventDescriptionResponse> getAll() {
        return getCase.getAllEventDescription().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/getEventDescriptionByEventId/{eventId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Event Description by Event ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventDescriptionResponse.class) // ✅
                                                                                                                                                                                                                       // usar
                                                                                                                                                                                                                       // DTO
            )),
            @ApiResponse(responseCode = "404", description = "Event Description not found")
    })
    public ResponseEntity<EventDescriptionResponse> getEventDescriptionByEventId(
            @PathVariable Long eventId) {
        return getCase.getEventDescriptionByEventId(eventId)
                .map(mapper::toResponse) // mapea Domain → Response DTO
                .map(ResponseEntity::ok) // envuelve en 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 si no existe
    }

}
