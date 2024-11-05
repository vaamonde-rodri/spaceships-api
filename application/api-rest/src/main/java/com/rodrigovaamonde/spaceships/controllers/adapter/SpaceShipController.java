package com.rodrigovaamonde.spaceships.controllers.adapter;

import com.rodrigovaamonde.spaceships.controllers.api.SpaceShipApi;
import com.rodrigovaamonde.spaceships.controllers.dto.SpaceShipDTO;
import com.rodrigovaamonde.spaceships.controllers.mapper.SpaceShipMapper;
import com.rodrigovaamonde.spaceships.domain.port.application.SpaceShipPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SpaceShipController implements SpaceShipApi {

  private final SpaceShipPort spaceShipPort;
  private final SpaceShipMapper spaceShipMapper;

  @Override
  public ResponseEntity<SpaceShipDTO> createSpaceShip(SpaceShipDTO spaceShipDTO) {
    return Optional.ofNullable(spaceShipDTO)
        .map(
            dto ->
                ResponseEntity.ok(
                    spaceShipMapper.toDTO(spaceShipPort.create(spaceShipMapper.toDomain(dto)))))
        .orElse(ResponseEntity.badRequest().build());
  }

  @Override
  public ResponseEntity<SpaceShipDTO> updateSpaceShip(Long id, SpaceShipDTO spaceShipDTO) {
    return Optional.ofNullable(spaceShipDTO)
        .map(
            dto ->
                ResponseEntity.ok(
                    spaceShipMapper.toDTO(spaceShipPort.update(id, spaceShipMapper.toDomain(dto)))))
        .orElse(ResponseEntity.badRequest().build());
  }

  @Override
  public ResponseEntity<SpaceShipDTO> getSpaceShip(Long id) {
    SpaceShipDTO spaceShipDTO = spaceShipMapper.toDTO(spaceShipPort.findById(id));

    return ResponseEntity.ok(spaceShipDTO);
  }

  @Override
  public ResponseEntity<Void> deleteSpaceShip(Long id) {
    spaceShipPort.delete(id);
    return ResponseEntity.noContent().build();
  }
}
