package com.rodrigovaamonde.spaceships.domain.usecase;

import com.rodrigovaamonde.spaceships.domain.annotation.UseCase;
import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import com.rodrigovaamonde.spaceships.domain.port.application.SpaceShipPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class SpaceShipUseCase implements SpaceShipPort {

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
        return SpaceShip.builder().build();
    }

    @Override
    public SpaceShip update(Long id, SpaceShip spaceShip) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
