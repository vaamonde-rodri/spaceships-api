package com.rodrigovaamonde.spaceships.domain.port.infrastructure;

import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;

public interface KafkaProducerPort {
    void produceSpaceShipMessage(SpaceShip spaceShip);
}
