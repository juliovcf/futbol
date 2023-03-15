package com.torneo.futbol.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.torneo.futbol.dao.MatchDao;
import com.torneo.futbol.model.Match;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.repository.MatchEventRepository;
import com.torneo.futbol.repository.TeamRepository;
import com.torneo.futbol.service.MatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDao matchDao;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchEventRepository matchEventRepository;

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
    public void simulateMatch(Long team1Id, Long team2Id) {
        Team team1 = teamRepository.findById(team1Id).orElse(null);
        Team team2 = teamRepository.findById(team2Id).orElse(null);

        if (team1 == null || team2 == null) {
            throw new IllegalArgumentException("Invalid team id");
        }

        int team1Quality = team1.getQuality();
        int team2Quality = team2.getQuality();
        //int totalQuality = team1Quality + team2Quality;

        for (int i = 0; i < 45; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
            int team1Chance = (int) ((randomNumber * team1Quality) / 2);
            int team2Chance = (int) ((randomNumber * team2Quality) / 2);

            if (team1Chance > team2Chance) {
                MatchEvent event = selectRandomEvent();
                matchEventRepository.save(event);
            }
        }

        for (int i = 0; i < 45; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
            int team1Chance = (int) ((randomNumber * team1Quality) / 2);
            int team2Chance = (int) ((randomNumber * team2Quality) / 2);

            if (team1Chance > team2Chance) {
                MatchEvent event = selectRandomEvent();
                matchEventRepository.save(event);
            }
        }
    }

    private MatchEvent selectRandomEvent() {
        List<MatchEvent> eventTypes = matchEventRepository.findAll();
        int size = eventTypes.size();
        int randomIndex = ThreadLocalRandom.current().nextInt(0, size);
        MatchEvent eventType = eventTypes.get(randomIndex);
        return new MatchEvent(eventType);
    }

    @Override
    public List<Match> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return matchDao.findByDateBetween(startDate, endDate);
    }
}
