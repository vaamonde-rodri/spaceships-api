package com.rodrigovaamonde.spaceships.domain.port.infrastructure;

import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpaceShipDatabasePort {
    Page<SpaceShip> findAll(Pageable pageable);

    SpaceShip findById(Long id);

    Page<SpaceShip> findByName(String name, Pageable pageable);

    SpaceShip save(SpaceShip spaceShip);

    void delete(Long id);

}
