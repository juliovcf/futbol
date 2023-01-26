package com.torneo.futbol.service.impl;

import java.util.Collection;

import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.service.IMatchEventService;

import org.springframework.stereotype.Service;

@Service
public class MatchEventService implements IMatchEventService {

    @Override
    public MatchEvent get(Long id) {

        return null;
    }

    @Override
    public Collection<MatchEvent> getByMatchID(Long matchID) {
        return null;
    }

    @Override
    public Collection<MatchEvent> get(Collection<Long> id) {
        return null;
    }

}
