package com.torneo.futbol.dao.impl;

import java.util.Collection;

import com.torneo.futbol.dao.MatchEventDao;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.repository.MatchEventRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class MatchEventDaoImpl implements MatchEventDao {

    @Autowired
    private MatchEventRepository matchEventRepository;

    @Override
    public Collection<MatchEvent> getByMatchId(Long matchId) {
        return null;
    }
    
}
