package com.sagar.memoryvault.repository;

import com.sagar.memoryvault.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID> {
    List<User> getUsersById(UUID id);

    Optional<User> getUserById(UUID id);
}
