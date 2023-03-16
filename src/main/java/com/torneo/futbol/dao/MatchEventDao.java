package com.torneo.futbol.dao;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.model.MatchEvent;

public interface MatchEventDao {

    MatchEvent create(MatchEvent matchevent);

    List<MatchEvent> findAll();

    Optional<MatchEvent> findByID(Long id);

    MatchEvent update(Long id, MatchEvent matchEvent);

    void delete(Long id);

    List<MatchEvent> getByMatchId(Long matchId);

}
