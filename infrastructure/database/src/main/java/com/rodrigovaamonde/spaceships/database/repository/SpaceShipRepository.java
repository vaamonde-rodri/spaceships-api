package com.rodrigovaamonde.spaceships.database.repository;

import com.rodrigovaamonde.spaceships.database.model.SpaceShipMO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceShipRepository extends JpaRepository<SpaceShipMO, Long> {

    Page<SpaceShipMO> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
