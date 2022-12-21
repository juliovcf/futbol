package com.torneo.futbol.model;

import java.sql.Date;

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

public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_match;

    private Date date;

    @ManyToOne
    @JoinTable(name = "team")
    @JoinColumn(name = "id_team")
    private Team homeTeam;

    @ManyToOne
    @JoinTable(name = "team")
    @JoinColumn(name = "id_equipo")
    private Team awatTeam;

    private String result;

    private String goalsHome;
    
    private String goalsAway;   
}
