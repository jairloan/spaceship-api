package com.example.spaceshipapi.service;

import com.example.spaceshipapi.model.Spaceship;
import com.example.spaceshipapi.repository.SpaceshipRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SpaceshipService {

  @Autowired
  private SpaceshipRepository spaceshipRepository;

  public List<Spaceship> getAllSpaceships(int page, int size) {
    return spaceshipRepository.findAll(PageRequest.of(page, size)).getContent();
  }

  public Optional<Spaceship> getSpaceshipById(Long id) {
    return spaceshipRepository.findById(id);
  }

  public List<Spaceship> searchSpaceshipsByName(String name) {
    return spaceshipRepository.findByNameContaining(name);
  }

  public Spaceship createSpaceship(Spaceship spaceship) {
    return spaceshipRepository.save(spaceship);
  }

  public Spaceship updateSpaceship(Long id, Spaceship spaceship) {
    spaceship.setId(id);
    return spaceshipRepository.save(spaceship);
  }

  public void deleteSpaceship(Long id) {
    spaceshipRepository.deleteById(id);
  }

}
