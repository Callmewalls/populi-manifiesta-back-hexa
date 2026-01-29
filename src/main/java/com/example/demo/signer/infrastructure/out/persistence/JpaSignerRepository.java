package com.example.demo.signer.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaSignerRepository
        extends JpaRepository<SignerEntity, Long> {

    @Query("Select e from SignerEntity e where e.name=:name")
    public Optional<SignerEntity> findBySignerName(String name);

    @Query("Select e from SignerEntity e where e.userId=:userId")
    public Optional<SignerEntity> findByUserId(Long userId);
}
