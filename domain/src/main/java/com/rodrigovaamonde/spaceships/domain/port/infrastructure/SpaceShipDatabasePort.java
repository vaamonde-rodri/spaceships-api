package com.rodrigovaamonde.spaceships.domain.port.infrastructure;

import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SpaceShipDatabasePort {
    List<SpaceShip> findAll(Pageable pageable);

    SpaceShip findById(Long id);

    List<SpaceShip> findByName(String name);

    SpaceShip save(SpaceShip spaceShip);

    void delete(Long id);

}
