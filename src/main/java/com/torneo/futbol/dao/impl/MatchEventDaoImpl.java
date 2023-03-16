package com.torneo.futbol.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.torneo.futbol.dao.MatchEventDao;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.repository.MatchEventRepository;

@Repository
public class MatchEventDaoImpl implements MatchEventDao {

    @Autowired
    MatchEventRepository matchEventRepository;

    @Override
    public List<MatchEvent> getByMatchId(Long matchId) {
        return matchEventRepository.findByMatchId(matchId);
    }

    @Override
    public MatchEvent create(MatchEvent matchevent) {
        return matchEventRepository.save(matchevent);
    }

    @Override
    public List<MatchEvent> findAll() {
        return matchEventRepository.findAll();
    }

    @Override
    public Optional<MatchEvent> findByID(Long id) {
        return matchEventRepository.findById(id);
    }

    @Override
    public MatchEvent update(Long id, MatchEvent matchEvent) {
        matchEvent.setId(id);
        return matchEventRepository.save(matchEvent);
    }

    @Override
    public void delete(Long id) {
        matchEventRepository.deleteById(id);
    }

}
