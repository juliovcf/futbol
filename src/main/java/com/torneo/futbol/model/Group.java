package com.torneo.futbol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "\"group\"")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Team team;

    @Column(name = "groupname", nullable = false)
    private String groupName;

    @Column(name = "points")
    private Integer points;

    @Column(name = "goals_Scored")
    private Integer goalsScored;

    @Column(name = "goals_Against")
    private Integer goalsAgainst;

}
