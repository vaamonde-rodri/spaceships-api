package com.rodrigovaamonde.spaceships.kafkaproducer.adapter;

import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import com.rodrigovaamonde.spaceships.domain.port.infrastructure.KafkaProducerPort;
import com.rodrigovaamonde.spaceships.domain.model.EventType;
import com.rodrigovaamonde.spaceships.kafkaproducer.event.SpaceShipEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer implements KafkaProducerPort {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  @Value("${spring.kafka.topic}")
  private String topic;

  @Override
  public void produceSpaceShipMessage(EventType eventType, SpaceShip spaceShip) {
    SpaceShipEvent spaceShipEvent = SpaceShipEvent.builder()
        .eventType(eventType)
        .timestamp(System.currentTimeMillis())
        .id(spaceShip.getId())
        .name(spaceShip.getName())
        .description(spaceShip.getDescription())
        .source(spaceShip.getSource())
        .build();
    kafkaTemplate.send(topic, spaceShip);
  }
}
