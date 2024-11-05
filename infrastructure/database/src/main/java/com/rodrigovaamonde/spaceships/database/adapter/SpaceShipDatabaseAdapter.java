package com.rodrigovaamonde.spaceships.database.adapter;

import com.rodrigovaamonde.spaceships.database.mapper.SpaceShipDatabaseMapper;
import com.rodrigovaamonde.spaceships.database.model.SpaceShipMO;
import com.rodrigovaamonde.spaceships.database.repository.SpaceShipRepository;
import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import com.rodrigovaamonde.spaceships.domain.port.infrastructure.SpaceShipDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpaceShipDatabaseAdapter implements SpaceShipDatabasePort {

  private final SpaceShipRepository spaceShipRepository;
  private final SpaceShipDatabaseMapper spaceShipDatabaseMapper;

  @Override
  public List<SpaceShip> findAll() {
    return List.of();
  }

  @Override
  public SpaceShip findById(Long id) {
    Optional<SpaceShipMO> spaceShipMO = spaceShipRepository.findById(id);

    return spaceShipMO.map(spaceShipDatabaseMapper::toDomain).orElse(null);
  }

  @Override
  public List<SpaceShip> findByName(String name) {
    return List.of();
  }

  @Override
  public SpaceShip save(SpaceShip spaceShip) {
    return spaceShipDatabaseMapper.toDomain(
        spaceShipRepository.save(spaceShipDatabaseMapper.toMO(spaceShip)));
  }

  @Override
  public void delete(Long id) {}
}