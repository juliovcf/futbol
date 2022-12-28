package com.torneo.futbol.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table (name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_match;

    private Date date;

    @ManyToOne
    @JoinTable(name = "team")
    @JoinColumn(name = "id_team")
    private Team homeTeam;

    private String goalsHome;

    @ManyToOne
    @JoinTable(name = "team")
    @JoinColumn(name = "id_team")
    private Team awayTeam;

    private String goalsAway;   
}
