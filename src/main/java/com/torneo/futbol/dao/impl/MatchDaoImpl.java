package com.torneo.futbol.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.torneo.futbol.dao.MatchDao;
import com.torneo.futbol.model.Match;
import com.torneo.futbol.repository.MatchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MatchDaoImpl implements MatchDao {

    @Autowired
    MatchRepository matchRepository;

    @Override
    public Match create(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    @Override
    public Optional<Match> findById(Long id) {
        return matchRepository.findById(id);
    }

    @Override
    public Match update(Long id, Match match) {
        match.setId_match(id);
        return matchRepository.save(match);
    }

    @Override
    public void delete(Long id) {
        matchRepository.deleteById(id);
    }

    @Override
    public List<Match> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return matchRepository.findByDateBetween(startDate, endDate);
    }

}
