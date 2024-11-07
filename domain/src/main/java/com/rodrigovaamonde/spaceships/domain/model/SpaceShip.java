package com.rodrigovaamonde.spaceships.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpaceShip {
    private Long id;
    private String name;
    private String description;
    private String source;
}
