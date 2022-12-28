package com.torneo.futbol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "matchEvent")
public class MatchEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match matchId;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player playerId;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team teamId;

    @ManyToOne
    @JoinColumn(name = "event_type_id", nullable = false)
    private MatchEventType eventTypeId;

    @Column(name = "minute", nullable = false)
    private Integer minute;

}
