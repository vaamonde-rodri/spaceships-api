package com.rodrigovaamonde.spaceships.controllers.adapter;

import com.rodrigovaamonde.spaceships.controllers.api.SpaceShipApi;
import com.rodrigovaamonde.spaceships.controllers.dto.SpaceShipDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SpaceShipController implements SpaceShipApi {

    @Override
    public ResponseEntity<SpaceShipDTO> createSpaceShip(SpaceShipDTO spaceShipDTO) {
        return SpaceShipApi.super.createSpaceShip(spaceShipDTO);
    }
}
