package com.example.demo.location_related.location.infrastructure.in.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.location_related.location.application.ports.in.GetLocationUseCase;
import com.example.demo.location_related.location.domain.Location;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("locations")
public class LocationController {

    GetLocationUseCase getUseCase;
    LocationWebMapper mapper;

    public LocationController(GetLocationUseCase getUseCase, LocationWebMapper mapper) {
            this.getUseCase = getUseCase;
            this.mapper = mapper;
    }

    @GetMapping("/getAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = LocationResponse.class)))),
            @ApiResponse(responseCode = "400", content = {
                    @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
    })
    public List<LocationResponse> getAll(
    ) {
        return this.getUseCase.getAll().stream().limit(1000).map(mapper::toResponse).toList();
    }

    
    @GetMapping("/getMarkersForADate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = LocationMapMarkerResponse.class)))),
            @ApiResponse(responseCode = "400", content = {
                    @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
    })
    public List<LocationMapMarkerResponse> getMarkersForADate( @RequestParam String date
    ) {
        Map<Long, Location> locationsMap = this.getUseCase.getLocationsForDate(LocalDate.parse(date));
        
        return locationsMap.values().stream().map(mapper::toMapMarkerResponse).toList();
    }
}
