package com.rodrigovaamonde.spaceships.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SpaceShip {
    private String name;
    private String description;
    private String source;
}
