package com.example.spaceshipapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.example.spaceshipapi.model.Spaceship;
import com.example.spaceshipapi.repository.SpaceshipRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpaceshipServiceTest {

  @Mock
  private SpaceshipRepository spaceshipRepository;

  @InjectMocks
  private SpaceshipService spaceshipService;

  @Test
  void testGetSpaceshipById(){
    Spaceship spaceship = new Spaceship();
    spaceship.setId(1L);
    spaceship.setName("X-Wing");
    spaceship.setSeries("Star Wars");
    spaceship.setDescription("A ship starfighter used by the Rebel Alliance.");

    when(spaceshipRepository.findById(1L)).thenReturn(Optional.of(spaceship));

    Optional <Spaceship> result = spaceshipService.getSpaceshipById(1L);

    assertTrue(result.isPresent());
    assertEquals("X-Wing", result.get().getName());
    assertEquals("Star Wars", result.get().getSeries());
    assertEquals("A ship starfighter used by the Rebel Alliance.", result.get().getDescription());
  }
}
