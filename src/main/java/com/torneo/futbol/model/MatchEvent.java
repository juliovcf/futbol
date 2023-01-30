package com.torneo.futbol.model;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class MatchEvent {
    public MatchEvent(MatchEvent eventType) {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Match match;

    @ManyToOne(optional = false)
    private Player player;

    @ManyToOne(optional = false)
    private Team team;

    @ManyToOne(optional = false)
    private MatchEventType eventType;

    @Column(name = "minute", nullable = false)
    private Integer minute;

}
