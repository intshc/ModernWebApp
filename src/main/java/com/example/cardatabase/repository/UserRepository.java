package com.example.cardatabase.repository;

import com.example.cardatabase.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
