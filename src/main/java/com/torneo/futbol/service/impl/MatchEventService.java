package com.torneo.futbol.service.impl;

import java.util.Collection;
import java.util.Optional;

import com.torneo.futbol.dao.IMatchEventDao;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.service.IMatchEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchEventService implements IMatchEventService{

    @Autowired
    private IMatchEventDao matchEventDao;

    @Override
    public MatchEvent get(Long id) {
        
        return matchEventDao.findById(id).get();
    }

    @Override
    public Collection<MatchEvent> getByMatchID(Long matchID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<MatchEvent> get(Collection<Long> id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
