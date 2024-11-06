package com.rodrigovaamonde.spaceships.kafkaproducer.event;

import com.rodrigovaamonde.spaceships.domain.model.EventType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SpaceShipEvent {
    private EventType eventType;
    private Long timestamp;

    private Long id;
    private String name;
    private String description;
    private String source;
}
