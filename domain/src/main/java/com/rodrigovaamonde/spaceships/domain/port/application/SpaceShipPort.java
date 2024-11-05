package com.rodrigovaamonde.spaceships.domain.port.application;

import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpaceShipPort {

    Page<SpaceShip> findAll(int page, int size);

    SpaceShip findById(Long id);

    List<SpaceShip> findByName(String name);

    SpaceShip create(SpaceShip spaceShip);

    SpaceShip update(Long id, SpaceShip spaceShip);

    void delete(Long id);
}
