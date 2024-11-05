package com.rodrigovaamonde.spaceships.domain.usecase;

import com.rodrigovaamonde.spaceships.domain.annotation.UseCase;
import com.rodrigovaamonde.spaceships.domain.exception.InvalidInputException;
import com.rodrigovaamonde.spaceships.domain.exception.ResourceNotFoundException;
import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import com.rodrigovaamonde.spaceships.domain.port.application.SpaceShipPort;
import com.rodrigovaamonde.spaceships.domain.port.infrastructure.SpaceShipDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class SpaceShipUseCase implements SpaceShipPort {

  private final SpaceShipDatabasePort spaceShipDatabasePort;

  @Override
  @Cacheable(value = "spaceShips", key = "#page + '-' + #size")
  public Page<SpaceShip> findAll(int page, int size) {

    if (page < 0 || size <= 0) {
      throw new InvalidInputException("Page and size must be greater than 0");
    }

    Pageable pageable = PageRequest.of(page, size);

    return spaceShipDatabasePort.findAll(pageable);
  }

  @Override
  @Cacheable(value = "spaceShips", key = "#id")
  public SpaceShip findById(Long id) {

    if (id == null || id <= 0) {
      throw new InvalidInputException("Id must be greater than 0");
    }


    SpaceShip spaceShip = spaceShipDatabasePort.findById(id);

    return Optional.ofNullable(spaceShip)
        .orElseThrow(
            () ->
                new ResourceNotFoundException(String.format("SpaceShip with id %s not found", id)));
  }

  @Override
  @Cacheable(value = "spaceShips", key = "#name + '-' + #page + '-' + #size")
  public Page<SpaceShip> findByName(String name, int page, int size) {

    if (name == null || name.isEmpty()) {
      throw new InvalidInputException("Name must not be empty");
    }

    if (page < 0 || size <= 0) {
      throw new InvalidInputException("Page and size must be greater than 0");
    }

    Pageable pageable = PageRequest.of(page, size);
    return spaceShipDatabasePort.findByName(name, pageable);
  }

  @Override
  public SpaceShip create(SpaceShip spaceShip) {

    if (spaceShip == null) {
      throw new InvalidInputException("SpaceShip must not be null");
    }

    return spaceShipDatabasePort.save(spaceShip);
  }

  @Override
  public SpaceShip update(Long id, SpaceShip spaceShip) {

    if (id == null || id <= 0) {
      throw new InvalidInputException("Id must be greater than 0");
    }

    if (spaceShip == null) {
      throw new InvalidInputException("SpaceShip must not be null");
    }


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

    if (id == null || id <= 0) {
      throw new InvalidInputException("Id must be greater than 0");
    }

    spaceShipDatabasePort.delete(id);
  }
}
