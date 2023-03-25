package com.torneo.futbol.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.torneo.futbol.config.Logger;
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
    public Match simulateMatch(Match match) {
        Logger.info("Comienza el partido entre " + match.getHomeTeam() + " y " + match.getAwayTeam());
        List<MatchEvent> events = new ArrayList<>();
        // Simular las dos partes del partido
        Logger.info("Simulando la primera parte");
        events.addAll(simulateHalf(match));
        Logger.info("Simulando la segunda parte");
        events.addAll(simulateHalf(match));
        
        Logger.info("Fin del partido");
        Logger.info("Resultado: " + match.getHomeTeam() + " " + match.getGoalsHome() + " - " + match.getGoalsAway() + " " + match.getAwayTeam());
        // Guardar el resultado en la base de datos
        // saveMatchResult(match);

        return match;
    }

    private List<MatchEvent> simulateHalf(Match match) {
        List<MatchEvent> events = new ArrayList<>();

        for (int j = 0; j < 45; j++) {
            MatchEvent event = generateRandomEvent(match, j);
            if (event != null) {
                events.add(event);
                j = event.getMinute();
            }
        }

        return events;
    }

    private MatchEvent generateRandomEvent(Match match, int minute) {
        Random random = new Random();
        int randomEvent = random.nextInt(100);
        Team team = selectTeam(match);
        // Probabilidad de eventos (ajustar según preferencia)
        if (randomEvent < 10) { // 10 de probabilidad de falta
            Logger.info("Falta " + "en el minuto " + minute);
            return generateFoulEvent(match, minute + 2, team);
        } else if (randomEvent < 30) { // 20% de probabilidad de ocasion de gol
            Logger.info("Ocasion de gol para " + team + "en el minuto " + minute);
            return generateOcasionEvent(match, minute + 1, team);
        } else {
            return null; // Nada ocurre en esta iteración
        }
    }

    private MatchEvent generateOcasionEvent(Match match, int minute, Team team) {
        Random random = new Random();
        int randomEvent = random.nextInt(100);
        // Probabilidad de eventos (ajustar según preferencia)
        if (randomEvent < 20) { // 20% de probabilidad de corner
            return generateCornerEvent(match, minute + 1, team);
        } else if (randomEvent < 50) { // 30% de probabilidad de ocasion de gol
            return generateGoalEvent(match, minute + 3, team);
        } else {
            return null; // Nada ocurre en esta iteración
        }
    }

    private MatchEvent generateFoulEvent(Match match, int minute, Team team) {
        Random random = new Random();
        int randomEvent = random.nextInt(100);
        if (randomEvent < 5) { // 5% de probabilidad de que sea un penalti
            Logger.info("Penalti para " + team + "en el minuto " + minute);
            return generatePenalEvent(match, minute, team);
        } else if (randomEvent < 20) { // 15% de probabilidad de gol de falta directa
            Logger.info("Gol de falta directa para " + team + "en el minuto " + minute);
            return generateGoalEvent(match, minute, team);
        } else{
            Logger.info("Falta sin consecuencias para " + team + "en el minuto " + minute);
            return null;
        }
    }
    //How to generate random events in a football match
    private MatchEvent generateInjuryEvent(Match match, int minute, Team team) {
        return null;
    }

    private MatchEvent generateRedCardEvent(Match match, int minute, Team team) {
        return null;
    }

    private MatchEvent generateYellowCardEvent(Match match, int minute, Team team) {
        return null;
    }

    private MatchEvent generatePenalEvent(Match match, int minute, Team team) {
        Random random = new Random();
        int randomEvent = random.nextInt(100);
        if (randomEvent < 80) { // 80% de probabilidad de gol en penalti
            return generateGoalEvent(match, minute, team);
        } else if (randomEvent < 20) { // 20% de probabilidad de fallar el penalti
            Logger.info("Penalti fallado por " + team + "en el minuto " + minute);
            return generateCornerEvent(match, minute, team);
        }
        else return null;
    }

    private MatchEvent generateCornerEvent(Match match, int minute, Team team) {
        Random random = new Random();
        Logger.info("Corner para " + team + "en el minuto " + minute);
        int randomEvent = random.nextInt(100);
        if (randomEvent < 10) { // 10% de probabilidad de gol en corner
            Logger.info("Gol en corner para " + team + "en el minuto " + minute);
            return generateGoalEvent(match, minute, team);
        } else if (randomEvent < 20) { // 10% de probabilidad de tarjeta amarilla en corner
            Logger.info("Tarjeta amarilla en corner para " + team + "en el minuto " + minute);
            return generateCornerEvent(match, minute, team);
        }
        else return null;
    }

    private MatchEvent generateGoalEvent(Match match, int minute, Team team) {
        MatchEventType goalEventType = null;// Obtener el MatchEventType correspondiente a un gol;
        Player scoringPlayer = getRandomPlayer(team);
        if (team.equals(match.getHomeTeam())) {
            match.setGoalsHome(match.getGoalsHome() + 1);
        } else {
            match.setGoalsAway(match.getGoalsAway() + 1);
        }
        return new MatchEvent(match, scoringPlayer, team, goalEventType, minute);
    }

    private Player getRandomPlayer(Team team) {
        Random random = new Random();
        List<Player> players = playerDao.findPlayersByTeam(team);
        int randomIndex = random.nextInt(players.size());
        return players.get(randomIndex);
    }

    private Team selectTeam(Match match) {
        Team team = new Team();
        Random random = new Random();
        int totalQuality = match.getHomeTeam().getQuality() + match.getAwayTeam().getQuality();
        int randomQuality = random.nextInt(totalQuality);

        if (randomQuality < match.getHomeTeam().getQuality()) {
            team = match.getHomeTeam();
        } else {
            team = match.getAwayTeam();
        }
        return team;
    }

}
