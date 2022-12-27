package com.torneo.futbol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class MatchEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match matchId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player playerId;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team teamId;

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    private MatchEventType eventTypeId;

    @Column(name = "minute")
    private Integer minute;

}
