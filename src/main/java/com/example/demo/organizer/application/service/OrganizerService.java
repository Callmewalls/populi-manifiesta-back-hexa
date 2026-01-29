package com.example.demo.organizer.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.organizer.application.ports.in.GetOrganizerUseCase;
import com.example.demo.organizer.application.ports.out.OrganizerRepositoryPort;
import com.example.demo.organizer.domain.Organizer;

@Service
public class OrganizerService implements GetOrganizerUseCase {

    private final OrganizerRepositoryPort organizerRepositoryPort;

    public OrganizerService(OrganizerRepositoryPort organizerRepositoryPort) {
        this.organizerRepositoryPort = organizerRepositoryPort;
    }

    @Override
    public Organizer getOrganizerById(Long organizerId) {
        return organizerRepositoryPort.findById(organizerId)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));
    }

    @Override
    public List<Organizer> getAll() {
        return organizerRepositoryPort.findAll();
    }

}
