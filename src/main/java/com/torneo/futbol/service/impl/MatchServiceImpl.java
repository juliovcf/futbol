package com.torneo.futbol.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneo.futbol.config.Logger;
import com.torneo.futbol.dao.MatchDao;
import com.torneo.futbol.dao.MatchEventDao;
import com.torneo.futbol.dao.PlayerDao;
import com.torneo.futbol.model.Match;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.model.MatchEventType;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.repository.MatchEventTypeRepository;
import com.torneo.futbol.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDao matchDao;

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private MatchEventDao matchEventDao;

    @Autowired
    private MatchEventTypeRepository matchEventTypeRepository;

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
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();
        Team winner = null;
        Logger.info("Comienza el partido entre " + homeTeam + " y " + awayTeam);
        List<MatchEvent> events = new ArrayList<>();
        // Simular las dos partes del partido
        Logger.info("Simulando la primera parte");
        events.addAll(simulateHalf(match, 0, 45));
        Logger.info("Simulando la segunda parte");
        events.addAll(simulateHalf(match, 45, 90));

        // Simular la prorroga si es necesario
        if (match.isEliminatory() && match.getGoalsHome() == match.getGoalsAway()) {
            Logger.info("Simulando la primera parte de la prorroga");
            events.addAll(simulateHalf(match, 90, 105));
            Logger.info("Simulando la segunda parte de la prorroga");
            events.addAll(simulateHalf(match, 105, 120));

            // Simular los penaltis si es necesario
            if (match.isEliminatory() && match.getGoalsHome() == match.getGoalsAway()) {
                Logger.info("Simulando los penaltis");
                winner = simulatePenalties(homeTeam, awayTeam);
            }
        }

        // Asignar el ganador
        if (winner == null) {
            if (match.getGoalsHome() > match.getGoalsAway()) {
                winner = homeTeam;
            } else if (match.getGoalsHome() < match.getGoalsAway()) {
                winner = awayTeam;
            }
        }

        Logger.info("Fin del partido");
        Logger.info("Resultado: " + match.getHomeTeam().getName() + " " + match.getGoalsHome() + " - "
                + match.getGoalsAway() + " " + match.getAwayTeam().getName());
        // Guardar el resultado en la base de datos
        // saveMatchResult(match);

        Logger.info("Eventos del partido" + events);

        return match;
    }

    private List<MatchEvent> simulateHalf(Match match, int minIni, int minFin) {
        List<MatchEvent> events = new ArrayList<>();

        for (int j = minIni; j < minFin; j++) {
            MatchEvent event = generateRandomEvent(match, j);
            if (event != null) {
                events.add(event);
                j = event.getMinute();
                j += 2;
                // sleep(10000);
            }
        }

        return events;
    }

    /*
     * private void sleep(int i) {
     * try {
     * Thread.sleep(i);
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     * }
     */

    private MatchEvent generateRandomEvent(Match match, int minute) {
        Random random = new Random();
        int randomEvent = random.nextInt(100);
        Team team = selectTeam(match);
        // Probabilidad de eventos (ajustar según preferencia)
        if (randomEvent < 10) { // 10 de probabilidad de falta
            Logger.info("Falta " + "en el minuto " + minute + " para " + team.getName());
            // sleep(5000);
            return generateFoulEvent(match, minute + 2, team);
        } else if (randomEvent < 25) { // 15% de probabilidad de ocasion de gol
            Logger.info("Ocasion de gol para " + team.getName() + " en el minuto " + minute);
            // sleep(5000);
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
            return generateCornerEvent(match, minute + 3, team);
        } else if (randomEvent < 40) { // 20% de probabilidad de ocasion de gol
            return generateGoalEvent(match, minute + 1, team);
        } else {
            Logger.info("Ocasión fallada");
            // sleep(5000);
            return null; // Nada ocurre en esta iteración
        }
    }

    private MatchEvent generateFoulEvent(Match match, int minute, Team team) {
        Random random = new Random();
        int randomEvent = random.nextInt(100);
        if (randomEvent < 5) { // 5% de probabilidad de que sea un penalti
            Logger.info("Penalti para " + team.getName() + " en el minuto " + minute);
            // sleep(10000);
            return generatePenalEvent(match, minute, team);
        } else if (randomEvent < 15) { // 10% de probabilidad de gol de falta directa
            Logger.info("Gol de falta directa para " + team.getName() + " en el minuto " + minute);
            return generateGoalEvent(match, minute, team);
        } else {
            Logger.info("Falta sin consecuencias para " + team.getName());
            // sleep(5000);
            return null;
        }
    }
    // How to generate random events in a football match
    /*
     * private MatchEvent generateInjuryEvent(Match match, int minute, Team team) {
     * return null;
     * }
     * 
     * private MatchEvent generateRedCardEvent(Match match, int minute, Team team) {
     * return null;
     * }
     * 
     * private MatchEvent generateYellowCardEvent(Match match, int minute, Team
     * team) {
     * return null;
     * }
     */

    private MatchEvent generatePenalEvent(Match match, int minute, Team team) {
        Random random = new Random();
        int randomEvent = random.nextInt(100);
        if (randomEvent < 80) { // 80% de probabilidad de gol en penalti
            return generateGoalEvent(match, minute, team);
        } else if (randomEvent < 20) { // 20% de probabilidad de fallar el penalti
            Logger.info("Penalti fallado por " + team.getName() + "en el minuto " + minute);
            // sleep(5000);
            return generateCornerEvent(match, minute, team);
        } else
            return null;
    }

    private MatchEvent generateCornerEvent(Match match, int minute, Team team) {
        Random random = new Random();
        Logger.info("Corner para " + team.getName() + "en el minuto " + minute);
        int randomEvent = random.nextInt(100);
        if (randomEvent < 10) { // 10% de probabilidad de gol en corner
            Logger.info("Gol en corner para " + team.getName());
            return generateGoalEvent(match, minute, team);
        } else if (randomEvent < 20) { // 10% de probabilidad de tarjeta amarilla en corner
            Logger.info("Corner de nuevo para " + team.getName());
            return generateCornerEvent(match, minute, team);
        }
        Logger.info("Corner sin consecuencias para " + team.getName() + "en el minuto " + minute);
        return null;
    }

    private MatchEvent generateGoalEvent(Match match, int minute, Team team) {
        MatchEventType matchEventType = matchEventTypeRepository.findById(1L).orElse(null);
        Player scoringPlayer = getRandomPlayer(team);
        if (team.equals(match.getHomeTeam())) {
            match.setGoalsHome(match.getGoalsHome() + 1);
            Logger.info("Gol de " + match.getHomeTeam().getName() + " en el minuto " + minute);
        } else {
            match.setGoalsAway(match.getGoalsAway() + 1);
            Logger.info("Gol de " + match.getAwayTeam().getName() + " en el minuto " + minute);
        }
        if (scoringPlayer != null) {
            scoringPlayer.setGoals(scoringPlayer.getGoals() + 1);
        }
        Logger.info("Resultado: " + match.getGoalsHome() + " - " + match.getGoalsAway());
        return matchEventDao.create(new MatchEvent(null, match, scoringPlayer, team, matchEventType, minute));
    }

    private Player getRandomPlayer(Team team) {
        Random random = new Random();
        List<Player> players = new ArrayList<>();
        players = playerDao.findPlayersByTeam(team);
        if (players.isEmpty()) {
            return null;
        }
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

    private Team simulatePenalties(Team homeTeam, Team awayTeam) {
        int homeTeamScore = 0;
        int awayTeamScore = 0;
        int maxRounds = 5;
        Random random = new Random();

        for (int i = 0; i < maxRounds; i++) {
            // Simula el penalti del equipo local
            if (random.nextInt(100) < homeTeam.getQuality() - 10) {
                homeTeamScore++;
                Logger.info("Gol de penalti para " + homeTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
            }

            // Simula el penalti del equipo visitante
            if (random.nextInt(100) < awayTeam.getQuality() - 10) {
                awayTeamScore++;
                Logger.info("Gol de penalti para " + awayTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
            }
        }

        // Si hay empate después de 5 rondas, se continúa con la muerte súbita
        while (homeTeamScore == awayTeamScore) {
            Logger.info("Empate en penaltis, se continúa con la muerte súbita");
            // Simula el penalti del equipo local
            if (random.nextInt(100) < homeTeam.getQuality() - 10) {
                homeTeamScore++;
                Logger.info("Gol de penalti para " + homeTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
            } else {
                // Si el equipo visitante anota, gana
                if (random.nextInt(100) < awayTeam.getQuality() - 10) {
                    awayTeamScore++;
                    Logger.info(
                            "Gol de penalti para " + awayTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
                    break;
                }
            }

            // Simula el penalti del equipo visitante
            if (random.nextInt(100) < awayTeam.getQuality() - 10) {
                awayTeamScore++;
                Logger.info("Gol de penalti para " + awayTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
            } else {
                // Si el equipo local anota, gana
                if (random.nextInt(100) < homeTeam.getQuality() - 10) {
                    homeTeamScore++;
                    Logger.info(
                            "Gol de penalti para " + homeTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
                    break;
                }
            }
        }

        Team winner = homeTeamScore > awayTeamScore ? homeTeam : awayTeam;
        Logger.info("Se acabó la tanda de penaltis! Ganador: " + winner.getName());
        return winner;
    }

}
