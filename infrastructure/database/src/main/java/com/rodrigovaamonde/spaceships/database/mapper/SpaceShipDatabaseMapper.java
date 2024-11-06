package com.rodrigovaamonde.spaceships.database.mapper;

import com.rodrigovaamonde.spaceships.database.model.SpaceShipMO;
import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpaceShipDatabaseMapper {
    SpaceShipMO toMO(SpaceShip spaceShip);
    SpaceShip toDomain(SpaceShipMO spaceShipMO);
}
