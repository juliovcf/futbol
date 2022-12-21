package com.torneo.futbol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(name = "equipos")
    @JoinColumn(name = "id_equipo")
    private Team team;
    
    @Column(name = "groupName")
    private String groupName;

    @Column(name = "points")
    private int points;
   
    @Column(name = "goles_favor")
    private int goalsScored;

    @Column(name = "goles_contra")
    private int goalsAgainst;

}
