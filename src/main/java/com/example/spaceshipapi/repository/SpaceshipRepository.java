package com.example.spaceshipapi.repository;

import com.example.spaceshipapi.model.Spaceship;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
List<Spaceship> findByNameContaining(String name);
}
