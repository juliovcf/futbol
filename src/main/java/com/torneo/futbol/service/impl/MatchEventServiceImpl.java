package com.torneo.futbol.service.impl;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.dao.MatchEventDao;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.service.MatchEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchEventServiceImpl implements MatchEventService {

    @Autowired
    private MatchEventDao matchEventDao;

    @Override
    public Optional<MatchEvent> getById(Long id) {
        return matchEventDao.findByID(id);
    }

    @Override
    public List<MatchEvent> getAll() {
        return matchEventDao.findAll();
    }

    @Override
    public MatchEvent create(MatchEvent matchEvent) {
        return matchEventDao.create(matchEvent);
    }

    @Override
    public MatchEvent update(Long id, MatchEvent matchEvent) {
        matchEvent.setId(id);
        return matchEventDao.create(matchEvent);
    }

    @Override
    public void delete(Long id) {
        matchEventDao.delete(id);
    }

    @Override
    public List<MatchEvent> getByMatchID(Long matchID) {
        return matchEventDao.getByMatchId(matchID);
    }

}
