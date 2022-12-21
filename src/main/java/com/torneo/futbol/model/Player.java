package com.torneo.futbol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(name = "team")
    @JoinColumn(name = "id_team")
    private Team team;
    
    private String nombre;

    private String posicion;

    private Integer dorsal;

    private Integer calidad;

    private Integer goles;

    private Integer amarillas;

    private Integer rojas;

}
