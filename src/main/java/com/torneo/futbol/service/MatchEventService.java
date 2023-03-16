package com.torneo.futbol.service;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.model.MatchEvent;


public interface MatchEventService {

    Optional<MatchEvent> getById(Long id);

    List<MatchEvent> getAll();

    MatchEvent create(MatchEvent matchEvent);

    MatchEvent update(Long id, MatchEvent matchEvent);

    void delete(Long id);

    public List<MatchEvent> getByMatchID(Long matchID);

}
