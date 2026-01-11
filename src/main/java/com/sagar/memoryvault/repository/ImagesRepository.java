package com.sagar.memoryvault.repository;

import com.sagar.memoryvault.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImagesRepository extends JpaRepository<Image,UUID> {
}
