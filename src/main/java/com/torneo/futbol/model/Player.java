package com.torneo.futbol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Team team;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(nullable = false)
    private Integer quality;

    @Column(length = 2)
    private Integer number;

    @Column(length = 3, nullable = false, columnDefinition = "int default 0")
    private Integer goals;

    @Column(length = 3, nullable = false, columnDefinition = "int default 0")
    private Integer yellowCards;

    @Column(length = 3, nullable = false, columnDefinition = "int default 0")
    private Integer redCards;

    @Column(columnDefinition = "boolean default true")
    private boolean available;

}
