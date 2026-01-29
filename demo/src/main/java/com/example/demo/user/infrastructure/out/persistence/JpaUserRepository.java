package com.example.demo.user.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaUserRepository
                extends JpaRepository<UserEntity, Long> {

        // @Query("Select e from UserEntity e where e.username = :username")
        // public Optional<UserEntity> findByName(String username);

        @Query("Select e from UserEntity e where e.email = :email")
        public Optional<UserEntity> findByMail(String email);

        @Query("""
                            SELECT u FROM UserEntity u
                            JOIN FETCH u.role
                            WHERE u.email = :email
                        """)
        Optional<UserEntity> findByMailWithRole(@Param("email") String email);

}
