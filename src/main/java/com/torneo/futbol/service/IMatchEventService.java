package com.torneo.futbol.service;

import java.util.Collection;

import com.torneo.futbol.model.MatchEvent;

public interface IMatchEventService {

    public MatchEvent get(Long id);

    public Collection<MatchEvent> getByMatchID(Long matchID);

    public Collection<MatchEvent> get(Collection<Long> id);

}
