package com.example.demo.organizer.application.ports.in;

import java.util.List;

import com.example.demo.organizer.domain.Organizer;

public interface GetOrganizerUseCase {
    
    Organizer getOrganizerById(Long organizerId);

    List<Organizer> getAll();

}
