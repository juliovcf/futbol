package com.torneo.futbol.service;

import java.time.LocalDateTime;
import java.util.List;

import com.torneo.futbol.model.Match;

public interface MatchService {

    Match create(Match match);

    List<Match> findAll();

    Match findById(Long id);

    Match update(Long id, Match match);

    void delete(Long id);

    void simulateMatch(Long team1Id, Long team2Id);

    List<Match> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}