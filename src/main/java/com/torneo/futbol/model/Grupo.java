package com.torneo.futbol.model;

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
@Table(name = "grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(name = "equipos")
    @JoinColumn(name = "id_equipo")
    private Team equipo;
    
    @Column(name = "grupo")
    private String nombreGrupo;

    @Column(name = "puntos")
    private int puntos;
   
    @Column(name = "goles_favor")
    private int golesFavor;

    @Column(name = "goles_contra")
    private int golesContra;
    
}
