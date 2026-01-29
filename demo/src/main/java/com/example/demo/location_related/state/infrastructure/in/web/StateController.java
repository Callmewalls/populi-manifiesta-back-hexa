package com.example.demo.location_related.state.infrastructure.in.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.location_related.state.application.ports.in.GetStateUseCase;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("states")
public class StateController {

        GetStateUseCase getUseCase;
        StateWebMapper mapper;

        public StateController(GetStateUseCase getUseCase, StateWebMapper mapper) {
                this.getUseCase = getUseCase;
                this.mapper = mapper;
        }

        @GetMapping("/getAll")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StateResponse.class)))),
                        @ApiResponse(responseCode = "400", content = {
                                        @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
        })
        public List<StateResponse> getState() {
                return getUseCase.getAll().stream().map(mapper::toResponse).toList();
        }
}
