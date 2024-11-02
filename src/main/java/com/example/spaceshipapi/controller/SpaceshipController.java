package com.example.spaceshipapi.controller;

import com.example.spaceshipapi.model.Spaceship;
import com.example.spaceshipapi.service.SpaceshipService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spaceships")
public class SpaceshipController {

  @Autowired
  private SpaceshipService spaceshipService;

  @GetMapping
  public List<Spaceship> getAllSpaceships(@RequestParam int page, @RequestParam int size){
    return spaceshipService.getAllSpaceships(page, size);
  }

  @GetMapping("/{id}")
  public Optional<Spaceship> getSpaceshipById(@PathVariable Long id){
    return spaceshipService.getSpaceshipById(id);
  }

  @GetMapping("/search")
  public List<Spaceship> searchSpaceshipByName(@RequestParam String name){
    return spaceshipService.searchSpaceshipsByName(name);
  }

  @PostMapping
  public Spaceship createSpaceship(@RequestBody Spaceship spaceship){
    return spaceshipService.createSpaceship(spaceship);
  }

  @PutMapping("/{id}")
  public Spaceship updateSpaceship(@PathVariable Long id, @RequestBody Spaceship spaceship){
    return spaceshipService.updateSpaceship(id, spaceship);
  }

  @DeleteMapping("/{id}")
  public void deleteSpaceship(@PathVariable Long id){
    spaceshipService.deleteSpaceship(id);
  }
}
