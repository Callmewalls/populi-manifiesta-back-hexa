package com.example.demo.user.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.user.application.ports.out.UserRepositoryPort;
import com.example.demo.user.domain.User;

@Component
public class UserPersistenceAdapter
        implements UserRepositoryPort {

    private final JpaUserRepository repository;
    private final UserMapper mapper;

    public UserPersistenceAdapter(
            JpaUserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User save(User user) {

        UserEntity userEntity = mapper.toEntity(user);
        return mapper.toDomain(repository.save(userEntity));
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByMail(String email) {
        return repository.findByMail(email).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByMailWithRole(String mail) {
        return repository.findByMailWithRole(mail)
                .map(mapper::toDomain);
    }

}