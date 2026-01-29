package com.example.demo.day_description.infrastructure.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.day_description.application.ports.in.GetDayDescriptionUseCase;
import com.example.demo.day_description.domain.DayDescription;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/day-descriptions")
public class DayDescriptionController {

    GetDayDescriptionUseCase getUseCase;
    DayDescriptionWebMapper mapper;

    public DayDescriptionController(GetDayDescriptionUseCase getUseCase, DayDescriptionWebMapper mapper) {
        this.getUseCase = getUseCase;
        this.mapper = mapper;
    }

    @GetMapping("getAll")
    public List<DayDescriptionResponse> getAll() {
        return getUseCase.getAllDescriptions().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("getDayDescriptionForEvent/{id}")
    @ApiResponse(description = "Get Day Description for Event by Event ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DayDescription.class)))
    public ResponseEntity<DayDescriptionResponse> getDayDescriptionForEvent(@PathVariable Long id) {
        return getUseCase.getDayDescriptionByEventId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
