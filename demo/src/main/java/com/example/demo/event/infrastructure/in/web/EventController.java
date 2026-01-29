package com.example.demo.event.infrastructure.in.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.infrastructure.security.CustomUserDetails;
import com.example.demo.event.application.ports.in.GetEventUseCase;
import com.example.demo.event.application.ports.in.PostEventUseCase;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("events")
public class EventController {

        GetEventUseCase useCase;
        PostEventUseCase postCase;
        EventWebMapper mapper;

        public EventController(GetEventUseCase useCase, EventWebMapper mapper, PostEventUseCase postCase) {
                this.useCase = useCase;
                this.mapper = mapper;
                this.postCase = postCase;
        }

        @GetMapping("/getEventsForDate")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EventResponse.class)))),
                        @ApiResponse(responseCode = "400", content = {
                                        @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
        })
        public ResponseEntity<?> getEventForDate(
                        @RequestParam String dateTime // 2025-06-01
        ) {

                LocalDate date = LocalDate.parse(dateTime);

                return ResponseEntity.ok(this.useCase.getEventsForDate(date).stream().map(mapper::toResponse).toList());

        }

        
        @GetMapping("/getEventsByMonth/{monthNumber}")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EventResponse.class)))),
                        @ApiResponse(responseCode = "400", content = {
                                        @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
        })
        public ResponseEntity<?> getEventsByMonth(
                        @PathVariable Integer monthNumber
        ) {
                

                return ResponseEntity.ok(this.useCase.getEventsByMonth(monthNumber).stream().map(mapper::toResponse).toList());

        }

        @GetMapping("/getEventsOrganizersForDate")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EventOrganizerResponse.class)))),
                        @ApiResponse(responseCode = "400", content = {
                                        @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
        })
        public List<EventOrganizerResponse> getEventsOrganizersForDate(
                        @RequestParam String dateTime // 2025-06-01
        ) {

                LocalDate date = LocalDate.parse(dateTime);

                return this.useCase.getEventsOrganizersForDate(date).stream().map(mapper::toEventOResponse).toList();

        }

        @GetMapping("/getEventsForDateTime")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EventResponse.class))) }),
                        @ApiResponse(responseCode = "400", content = {
                                        @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
        })
        public ResponseEntity<?> getEventForDateTime(
                        @RequestParam String date // 2025-06-01
        ) {
                LocalDate localDate = LocalDate.parse(date);

                return ResponseEntity
                                .ok(this.useCase.getEventsForDate(localDate).stream().map(mapper::toResponse).toList());

        }

        @PostMapping("/createEvent")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class))
                        })
        })
        public ResponseEntity<EventResponse> createEvent(
                        EventRequest eventRequest, @AuthenticationPrincipal CustomUserDetails user) {
                return ResponseEntity.ok(
                                mapper.toResponse(
                                                this.postCase.createEvent(
                                                                eventRequest.dateTime(),
                                                                user.getId(),
                                                                eventRequest.cityId())));
        }
}
