package com.sagar.memoryvault.repository;

import com.sagar.memoryvault.entity.Memory;
import com.sagar.memoryvault.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemoryRepository extends JpaRepository<Memory,UUID> {

    Optional<Memory> findMemoryById(UUID memoryId);

    @Override
    void deleteById(UUID uuid);

    List<Memory> findAllByUser(User user);
}

