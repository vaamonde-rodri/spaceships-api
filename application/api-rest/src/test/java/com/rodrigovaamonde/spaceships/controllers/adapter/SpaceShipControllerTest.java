package com.rodrigovaamonde.spaceships.controllers.adapter;

import com.rodrigovaamonde.spaceships.controllers.dto.PagedResponse;
import com.rodrigovaamonde.spaceships.controllers.dto.SpaceShipDTO;
import com.rodrigovaamonde.spaceships.controllers.mapper.SpaceShipMapper;
import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import com.rodrigovaamonde.spaceships.domain.port.application.SpaceShipPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SpaceShipControllerTest {

  @Mock private SpaceShipPort spaceShipPort;

  @Mock private SpaceShipMapper spaceShipMapper;

  @InjectMocks private SpaceShipController spaceShipController;

  private SpaceShipDTO spaceShipDTO;

  @BeforeEach
  void setUp() {
    spaceShipDTO = SpaceShipDTO.builder().build();
    spaceShipDTO.setName("Test Ship");
  }

  @Test
  void createSpaceShipReturnsCreatedResource() {
    SpaceShip spaceShip = SpaceShip.builder().build();
    when(spaceShipMapper.toDomain(any(SpaceShipDTO.class))).thenReturn(spaceShip);
    when(spaceShipPort.create(any(SpaceShip.class))).thenReturn(spaceShip);
    when(spaceShipMapper.toDTO(any(SpaceShip.class))).thenReturn(spaceShipDTO);

    ResponseEntity<SpaceShipDTO> response = spaceShipController.createSpaceShip(spaceShipDTO);

    assertEquals(ResponseEntity.ok(spaceShipDTO), response);
  }

  @Test
  void createSpaceShipReturnsErrorResource() {
    ResponseEntity<SpaceShipDTO> response = spaceShipController.createSpaceShip(null);

    assertEquals(ResponseEntity.badRequest().build(), response);
  }

  @Test
  void updateSpaceShipReturnsUpdatedResource() {
    SpaceShip spaceShip = SpaceShip.builder().build();
    when(spaceShipMapper.toDomain(any(SpaceShipDTO.class))).thenReturn(spaceShip);
    when(spaceShipPort.update(any(Long.class), any(SpaceShip.class))).thenReturn(spaceShip);
    when(spaceShipMapper.toDTO(any(SpaceShip.class))).thenReturn(spaceShipDTO);

    ResponseEntity<SpaceShipDTO> response = spaceShipController.updateSpaceShip(1L, spaceShipDTO);

    assertEquals(ResponseEntity.ok(spaceShipDTO), response);
  }

  @Test
  void updateSpaceShipReturnsErrorResource() {
    ResponseEntity<SpaceShipDTO> response = spaceShipController.updateSpaceShip(1L, null);

    assertEquals(ResponseEntity.badRequest().build(), response);
  }

  @Test
  void getSpaceShipReturnsResource() {
    SpaceShip spaceShip = SpaceShip.builder().build();
    when(spaceShipPort.findById(any(Long.class))).thenReturn(spaceShip);
    when(spaceShipMapper.toDTO(any(SpaceShip.class))).thenReturn(spaceShipDTO);

    ResponseEntity<SpaceShipDTO> response = spaceShipController.getSpaceShip(1L);

    assertEquals(ResponseEntity.ok(spaceShipDTO), response);
  }

  @Test
  void deleteSpaceShipReturnsNoContent() {
    ResponseEntity<Void> response = spaceShipController.deleteSpaceShip(1L);

    assertEquals(ResponseEntity.noContent().build(), response);
  }

  @Test
  void getAllSpaceShipsReturnsPagedResponse() {
    SpaceShip spaceShip = SpaceShip.builder().build();
    Page<SpaceShip> spaceShipPage = new PageImpl<>(List.of(spaceShip));
    when(spaceShipPort.findAll(any(Integer.class), any(Integer.class))).thenReturn(spaceShipPage);
    when(spaceShipMapper.toDTO(any(SpaceShip.class))).thenReturn(spaceShipDTO);

    ResponseEntity<PagedResponse<SpaceShipDTO>> response = spaceShipController.getAllSpaceShips(0, 10);

    assertEquals(1, response.getBody().getData().size());
    assertEquals(ResponseEntity.ok().build().getStatusCode(), response.getStatusCode());
  }

  @Test
  void searchSpaceShipsReturnsPagedResponse() {
    SpaceShip spaceShip = SpaceShip.builder().build();
    Page<SpaceShip> spaceShipPage = new PageImpl<>(List.of(spaceShip));
    when(spaceShipPort.findByName(any(String.class), any(Integer.class), any(Integer.class))).thenReturn(spaceShipPage);
    when(spaceShipMapper.toDTO(any(SpaceShip.class))).thenReturn(spaceShipDTO);

    ResponseEntity<PagedResponse<SpaceShipDTO>> response = spaceShipController.searchSpaceShips("Test Ship", 0, 10);

    assertEquals(1, response.getBody().getData().size());
    assertEquals(ResponseEntity.ok().build().getStatusCode(), response.getStatusCode());
  }
}
