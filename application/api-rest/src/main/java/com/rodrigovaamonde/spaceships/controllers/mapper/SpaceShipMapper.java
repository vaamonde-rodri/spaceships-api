package com.rodrigovaamonde.spaceships.controllers.mapper;

import com.rodrigovaamonde.spaceships.controllers.dto.SpaceShipDTO;
import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpaceShipMapper {

  SpaceShipDTO toDTO(SpaceShip spaceShip);

  SpaceShip toDomain(SpaceShipDTO spaceShipDTO);
}
