package com.torneo.futbol.service;

import java.time.LocalDateTime;
import java.util.List;

import com.torneo.futbol.model.Match;
import com.torneo.futbol.model.Team;

public interface MatchService {

    Match create(Match match);

    List<Match> findAll();

    Match findById(Long id);

    Match update(Long id, Match match);

    void delete(Long id);

    List<Match> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    Match simulateMatch(Match match);

}