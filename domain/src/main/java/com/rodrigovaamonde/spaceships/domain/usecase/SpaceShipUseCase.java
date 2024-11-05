package com.rodrigovaamonde.spaceships.domain.usecase;

import com.rodrigovaamonde.spaceships.domain.annotation.UseCase;
import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import com.rodrigovaamonde.spaceships.domain.port.application.SpaceShipPort;
import com.rodrigovaamonde.spaceships.domain.port.infrastructure.SpaceShipDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class SpaceShipUseCase implements SpaceShipPort {

  private final SpaceShipDatabasePort spaceShipDatabasePort;

  @Override
  public List<SpaceShip> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);

    return spaceShipDatabasePort.findAll(pageable);
  }

  @Override
  public SpaceShip findById(Long id) {
    return spaceShipDatabasePort.findById(id);
  }

  @Override
  public List<SpaceShip> findByName(String name) {
    return List.of();
  }

  @Override
  public SpaceShip create(SpaceShip spaceShip) {
    return spaceShipDatabasePort.save(spaceShip);
  }

  @Override
  public SpaceShip update(Long id, SpaceShip spaceShip) {
    SpaceShip spaceShipToUpdate = spaceShipDatabasePort.findById(id);

    return Optional.ofNullable(spaceShipToUpdate)
        .map(
            s -> {
              s.setName(spaceShip.getName());
              s.setDescription(spaceShip.getDescription());
              s.setSource(spaceShip.getSource());
              return spaceShipDatabasePort.save(s);
            })
        .orElse(null);
  }

  @Override
  public void delete(Long id) {
    spaceShipDatabasePort.delete(id);
  }
}
