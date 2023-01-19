package com.torneo.futbol.dao;

import java.util.Collection;

import com.torneo.futbol.model.MatchEvent;

public interface MatchEventDao {

    public Collection<MatchEvent> getByMatchId(Long matchId);

}
