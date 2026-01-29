package com.example.demo.location_related.location.infrastructure.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaLocationRepository
        extends JpaRepository<LocationEntity, Long> {

        @Query("select l from LocationEntity l where l.id in :ids")
        public List<LocationEntity> findByIds(List<Long> ids);
}
