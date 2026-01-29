package com.example.demo.organizer.infrastructure.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaOrganizerRepository
        extends JpaRepository<OrganizerEntity, Long> {

        @Query("SELECT e FROM OrganizerEntity e WHERE e.id IN (:organizerIds)")
        public List<OrganizerEntity> findByIds(List<Long> organizerIds);
}
