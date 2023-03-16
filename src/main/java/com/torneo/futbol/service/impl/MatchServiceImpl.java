package com.torneo.futbol.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.torneo.futbol.dao.MatchDao;
import com.torneo.futbol.model.Match;
import com.torneo.futbol.service.MatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDao matchDao;

    @Override
    public Match create(Match match) {
        return matchDao.create(match);
    }

    @Override
    public List<Match> findAll() {
        return matchDao.findAll();
    }

    @Override
    public Match findById(Long id) {
        return matchDao.findById(id).orElse(null);
    }

    @Override
    public Match update(Long id, Match match) {
        return matchDao.update(id, match);
    }

    @Override
    public void delete(Long id) {
        matchDao.delete(id);
    }

    @Override
    public List<Match> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return matchDao.findByDateBetween(startDate, endDate);
    }
}
