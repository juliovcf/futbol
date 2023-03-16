package com.torneo.futbol.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.torneo.futbol.model.Match;

public interface MatchDao {

    Match create(Match match);

    List<Match> findAll();

    Optional<Match> findById(Long id);

    Match update(Long id, Match match);

    void delete(Long id);
    
    List<Match> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);


}
