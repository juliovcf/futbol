package com.torneo.futbol.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.torneo.futbol.dao.MatchDao;
import com.torneo.futbol.dao.PlayerDao;
import com.torneo.futbol.model.Match;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.model.MatchEventType;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.service.MatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDao matchDao;

    @Autowired
    private PlayerDao playerDao;

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

    @Override
    public List<MatchEvent> simulateMatch(Team homeTeam, Team awayTeam, Match match) {
        List<MatchEvent> events = new ArrayList<>();
        // Simular las dos partes del partido
        events.addAll(simulateHalf(match));
        events.addAll(simulateHalf(match));

        // Guardar el resultado en la base de datos
        //saveMatchResult(match);

        return events;
    }

    private List<MatchEvent> simulateHalf(Match match) {
        List<MatchEvent> events = new ArrayList<>();
    
        for (int j = 0; j < 45; j++) {
            MatchEvent event = generateRandomEvent(match, j);
            if (event != null) {
                events.add(event);
            }
        }
    
        return events;
    }
    

    private MatchEvent generateRandomEvent(Match match, int minute) {
        Random random = new Random();
        int randomEvent = random.nextInt(100);

        // Probabilidad de eventos (ajustar según preferencia)
    if (randomEvent < 5) { // 5% de probabilidad de gol
        return generateGoalEvent(match, minute);
    } else if (randomEvent < 10) { // 5% de probabilidad de corner
        return generateCornerEvent(match, minute);
    } else if (randomEvent < 15) { // 15% de probabilidad de falta
        return generateFoulEvent(match, minute);
    } 
    else {
        return null; // Nada ocurre en esta iteración
    }
    }

    private MatchEvent generateInjuryEvent(Match match, int minute) {
        return null;
    }

    private MatchEvent generateRedCardEvent(Match match, int minute) {
        return null;
    }

    private MatchEvent generateYellowCardEvent(Match match, int minute) {
        return null;
    }

    private MatchEvent generateFoulEvent(Match match, int minute) {
        Random random = new Random();
        int randomEvent = random.nextInt(100);
        if (randomEvent < 35) { // 10% de probabilidad de tarjeta amarilla
            return generateYellowCardEvent(match, minute);
        } else if (randomEvent < 41) { // 5% de probabilidad de tarjeta roja
            return generateRedCardEvent(match, minute);
        } else if (randomEvent < 46) { // 5% de probabilidad de lesión
            return generateInjuryEvent(match, minute);
        }
        return null;
    }

    private MatchEvent generateCornerEvent(Match match, int minute) {
        return null;
    }

    private MatchEvent generateGoalEvent(Match match, int minute) {
        Random random = new Random();
        int totalQuality = match.getHomeTeam().getQuality() + match.getAwayTeam().getQuality();
        int randomQuality = random.nextInt(totalQuality);

        MatchEventType goalEventType = null;// Obtener el MatchEventType correspondiente a un gol;
    
        if (randomQuality < match.getHomeTeam().getQuality()) {
            Player scoringPlayer = getRandomPlayer(match.getHomeTeam());
            match.setGoalsHome(match.getGoalsHome() + 1);
            return new MatchEvent(match, scoringPlayer, match.getHomeTeam(), goalEventType, minute);
        } else {
            Player scoringPlayer = getRandomPlayer(match.getAwayTeam());
            match.setGoalsAway(match.getGoalsAway() + 1);
            return new MatchEvent(match, scoringPlayer, match.getAwayTeam(), goalEventType, minute);
        }
    }

    private Player getRandomPlayer(Team team) {
        Random random = new Random();
        List<Player> players = playerDao.findPlayersByTeam(team);
        int randomIndex = random.nextInt(players.size());
        return players.get(randomIndex);
    }
    
}
