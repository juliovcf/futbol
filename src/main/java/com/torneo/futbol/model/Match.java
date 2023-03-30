package com.torneo.futbol.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime  date;

    @ManyToOne
    private Team homeTeam;

    @Column(columnDefinition = "integer default 0")
    private Integer goalsHome;

    @ManyToOne
    private Team awayTeam;

    @Column(columnDefinition = "integer default 0")
    private Integer goalsAway;

    @Column(columnDefinition = "boolean default false")
    private boolean played;
}
