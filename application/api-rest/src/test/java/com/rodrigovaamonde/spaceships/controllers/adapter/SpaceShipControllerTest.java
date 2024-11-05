package com.rodrigovaamonde.spaceships.controllers.adapter;

import com.rodrigovaamonde.spaceships.controllers.dto.SpaceShipDTO;
import com.rodrigovaamonde.spaceships.controllers.mapper.SpaceShipMapper;
import com.rodrigovaamonde.spaceships.domain.port.application.SpaceShipPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SpaceShipControllerTest {

  private SpaceShipController spaceShipController;

  @Mock private SpaceShipPort spaceShipPort;
  @Mock private SpaceShipMapper spaceShipMapper;

  @BeforeEach
  public void setUp() {
    spaceShipController = new SpaceShipController(spaceShipPort, spaceShipMapper);
  }

  @Test
  public void createSpaceShipReturnsResponseEntity() {
    SpaceShipDTO spaceShipDTO = SpaceShipDTO.builder().build();
    ResponseEntity<SpaceShipDTO> response = spaceShipController.createSpaceShip(spaceShipDTO);
    assertEquals(ResponseEntity.ok().build().getStatusCode(), response.getStatusCode());
  }

  @Test
  void createSpaceShipWithNullDTO() {
    ResponseEntity<SpaceShipDTO> response = spaceShipController.createSpaceShip(null);
    assertEquals(ResponseEntity.badRequest().build().getStatusCode(), response.getStatusCode());
  }

  @Test
  public void createSpaceShipReturnsErrorResource() {
    SpaceShipDTO spaceShipDTO = SpaceShipDTO.builder().build();
    ResponseEntity<SpaceShipDTO> response = spaceShipController.createSpaceShip(spaceShipDTO);
    assertEquals(ResponseEntity.badRequest().build().getStatusCode(), response.getStatusCode());
  }
}
