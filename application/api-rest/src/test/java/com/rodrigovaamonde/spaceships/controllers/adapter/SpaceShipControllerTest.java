package com.rodrigovaamonde.spaceships.controllers.adapter;

import com.rodrigovaamonde.spaceships.controllers.dto.SpaceShipDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceShipControllerTest {

  private SpaceShipController spaceShipController;

  @BeforeEach
  public void setUp() {
    spaceShipController = new SpaceShipController();
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
