package com.rodrigovaamonde.spaceships.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "spaceships")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SpaceShipMO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String source;
}
