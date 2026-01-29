package com.example.demo.organizer.infrastructure.in.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.organizer.application.ports.in.GetOrganizerUseCase;

@RestController
@RequestMapping("organizers")
public class OrganizerController {
    
    OrganizerWebMapper mapper;
    GetOrganizerUseCase getCase;
    
    public OrganizerController(OrganizerWebMapper mapper, GetOrganizerUseCase getCase) {
        this.mapper = mapper;
        this.getCase = getCase;
    }

    @GetMapping("/getAll")
    public List<OrganizerResponse> getAll(){
        return getCase.getAll().stream().map(mapper::toResponse).toList();
    }
}
