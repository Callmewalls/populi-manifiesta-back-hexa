package com.example.demo.location_related.state.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStateRepository
        extends JpaRepository<StateEntity, Long> {

}
