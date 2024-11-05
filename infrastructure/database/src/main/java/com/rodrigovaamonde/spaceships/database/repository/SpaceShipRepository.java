package com.rodrigovaamonde.spaceships.database.repository;

import com.rodrigovaamonde.spaceships.database.model.SpaceShipMO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceShipRepository extends JpaRepository<SpaceShipMO, Long> {}
