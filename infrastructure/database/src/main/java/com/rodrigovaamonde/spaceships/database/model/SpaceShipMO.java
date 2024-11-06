package com.rodrigovaamonde.spaceships.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "spaceships")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class SpaceShipMO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String source;
}
