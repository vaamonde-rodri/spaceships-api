package com.rodrigovaamonde.spaceships.domain.port.application;

import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import org.springframework.data.domain.Page;

public interface SpaceShipPort {

    Page<SpaceShip> findAll(int page, int size);

    SpaceShip findById(Long id);

    Page<SpaceShip> findByName(String name, int page, int size);

    SpaceShip create(SpaceShip spaceShip);

    SpaceShip update(Long id, SpaceShip spaceShip);

    void delete(Long id);
}
