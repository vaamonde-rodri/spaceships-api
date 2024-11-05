package com.rodrigovaamonde.spaceships.domain.port.infrastructure;

import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;

import java.util.List;

public interface SpaceShipDatabasePort {
    List<SpaceShip> findAll();

    SpaceShip findById(Long id);

    List<SpaceShip> findByName(String name);

    SpaceShip create(SpaceShip spaceShip);

    SpaceShip update(Long id, SpaceShip spaceShip);

    void delete(Long id);

}
