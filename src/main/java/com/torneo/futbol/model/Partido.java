package com.torneo.futbol.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partidos")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinTable(name = "equipos")
    @JoinColumn(name = "id_equipo")
    private Team equipoLocal;

    @ManyToOne
    @JoinTable(name = "equipos")
    @JoinColumn(name = "id_equipo")
    private Team equipoVisitante;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "goles_local")
    private String golesLocal;
    
    @Column(name = "goles_visitante")
    private String golesVisitante;

        
}
