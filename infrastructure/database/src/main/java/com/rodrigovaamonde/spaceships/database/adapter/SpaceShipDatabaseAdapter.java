package com.rodrigovaamonde.spaceships.database.adapter;

import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import com.rodrigovaamonde.spaceships.domain.port.infrastructure.SpaceShipDatabasePort;

import java.util.List;

public class SpaceShipDatabaseAdapter implements SpaceShipDatabasePort {

    @Override
    public List<SpaceShip> findAll() {
        return List.of();
    }

    @Override
    public SpaceShip findById(Long id) {
        return null;
    }

    @Override
    public List<SpaceShip> findByName(String name) {
        return List.of();
    }

    @Override
    public SpaceShip create(SpaceShip spaceShip) {
        return null;
    }

    @Override
    public SpaceShip update(Long id, SpaceShip spaceShip) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
