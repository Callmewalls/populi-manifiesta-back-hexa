package com.example.demo.location_related.city.infrastructure.in.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.location_related.city.application.ports.in.GetCityUseCase;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("citys")
public class CityController {

    GetCityUseCase getUseCase;
    CityWebMapper mapper;

    public CityController(GetCityUseCase getUseCase, CityWebMapper mapper) {
            this.getUseCase = getUseCase;
            this.mapper = mapper;
    }

    @GetMapping("/getAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CityResponse.class)))),
            @ApiResponse(responseCode = "400", content = {
                    @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
    })
    public List<CityResponse> getAll(
    ) {
        return this.getUseCase.getAll().stream().limit(1000).map(mapper::toResponse).toList();
    }
}
