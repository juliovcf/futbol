package com.torneo.futbol.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.torneo.futbol.config.Logger;
import com.torneo.futbol.dao.MatchDao;
import com.torneo.futbol.dao.MatchEventDao;
import com.torneo.futbol.dao.PlayerDao;
import com.torneo.futbol.model.Match;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.model.MatchEventType;
import com.torneo.futbol.model.Phase;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.repository.MatchEventTypeRepository;
import com.torneo.futbol.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchDao matchDao;
    private final PlayerDao playerDao;
    private final MatchEventDao matchEventDao;
    private final MatchEventTypeRepository matchEventTypeRepository;
    private final Random random;

    private int currentMinute;
    private Integer sleep;

    public MatchServiceImpl(MatchDao matchDao, PlayerDao playerDao, MatchEventDao matchEventDao,
                            MatchEventTypeRepository matchEventTypeRepository) {
        this.matchDao = matchDao;
        this.playerDao = playerDao;
        this.matchEventDao = matchEventDao;
        this.matchEventTypeRepository = matchEventTypeRepository;
        this.random = new Random();
    }

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
    public Match simulateMatch(Match match, Integer delay) {
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();
        Team winner = null;
        sleep = delay;

        Logger.info("Comienza el partido entre " + homeTeam.getName() + " y " + awayTeam.getName());
        List<MatchEvent> events = new ArrayList<>();
        events.addAll(simulateHalf(match, 0, 45));
        events.addAll(simulateHalf(match, 45, 90));

        if (match.isEliminatory() && match.getGoalsHome().equals(match.getGoalsAway())) {
            events.addAll(simulateHalf(match, 90, 105));
            events.addAll(simulateHalf(match, 105, 120));
            if (match.getGoalsHome().equals(match.getGoalsAway())) {
                winner = simulatePenalties(homeTeam, awayTeam);
            }
        }

        if (winner == null) {
            winner = (match.getGoalsHome() > match.getGoalsAway()) ? homeTeam : awayTeam;
        }

        Logger.info("Fin del partido. Resultado: " + homeTeam.getName() + " " + match.getGoalsHome() + " - "
                + match.getGoalsAway() + " " + awayTeam.getName());
        Logger.info("Eventos del partido: " + events);

        return match;
    }

    private List<MatchEvent> simulateHalf(Match match, int minIni, int minFin) {
        List<MatchEvent> events = new ArrayList<>();
        for (currentMinute = minIni; currentMinute < minFin; currentMinute++) {
            Phase phase = determinePhase(match);
            switch (phase) {
                case ATTACK_HOME -> events.addAll(simulateAttack(match, match.getHomeTeam()));
                case ATTACK_AWAY -> events.addAll(simulateAttack(match, match.getAwayTeam()));
                case DISPUTE -> Logger.info("El balón está en disputa en el minuto " + currentMinute);
                default -> Logger.info("El balón está en disputa en el minuto " + currentMinute);
            }
            wait(sleep);
        }
        return events;
    }

    private Phase determinePhase(Match match) {
        int chance = random.nextInt(100);
        int midfieldQualityHome = match.getHomeTeam().getMidfieldQuality();
        int midfieldQualityAway = match.getAwayTeam().getMidfieldQuality();
        int totalMidfieldQuality = midfieldQualityHome + midfieldQualityAway;

        if (chance < 50) {
            return Phase.DISPUTE;
        }

        int threshold = (int) (100.0 * midfieldQualityHome / totalMidfieldQuality);
        return (chance < threshold) ? Phase.ATTACK_HOME : Phase.ATTACK_AWAY;
    }

    private List<MatchEvent> simulateAttack(Match match, Team attackingTeam) {
        List<MatchEvent> events = new ArrayList<>();
        Team defendingTeam = (attackingTeam.equals(match.getHomeTeam())) ? match.getAwayTeam() : match.getHomeTeam();
        Logger.info(attackingTeam.getName() + " está atacando en el minuto " + currentMinute);

        int attackQuality = attackingTeam.getAttackQuality();
        int defenseQuality = defendingTeam.getDefenseQuality();
        int totalQuality = attackQuality + defenseQuality;
        int chance = random.nextInt(100);

        if (chance < (40 * attackQuality / totalQuality)) {
            Logger.info("El ataque continúa");
            events.addAll(simulateAttack(match, attackingTeam));
        } else if (chance < 50) {
            Logger.info("¡Gol de " + attackingTeam.getName() + "! en el minuto " + currentMinute);
            currentMinute += 2;
            events.add(generateGoalEvent(match, attackingTeam));
        } else if (chance < 60) {
            Logger.info("Falta cometida contra " + attackingTeam.getName());
            events.add(generateFoulEvent(match, attackingTeam));
        } else if (chance < 70) {
            Logger.info("Corner para " + attackingTeam.getName());
            events.add(generateCornerEvent(match, attackingTeam));
        } else {
            Logger.info("El balón vuelve a estar en disputa");
        }
        return events;
    }

    private MatchEvent generateFoulEvent(Match match, Team team) {
        int randomEvent = random.nextInt(100);
        if (randomEvent < 5) {
            Logger.info("Penalti para " + team.getName() + " en el minuto " + currentMinute);
            return generatePenalEvent(match, team);
        } else if (randomEvent < 15) {
            Logger.info("Gol de falta directa para " + team.getName() + " en el minuto " + currentMinute);
            return generateGoalEvent(match, team);
        } else {
            Logger.info("Falta sin consecuencias para " + team.getName());
            wait(sleep);
            return null;
        }
    }

    private MatchEvent generatePenalEvent(Match match, Team team) {
        int randomEvent = random.nextInt(100);
        if (randomEvent < 80) {
            return generateGoalEvent(match, team);
        } else {
            Logger.info("Penalti fallado por " + team.getName() + " en el minuto " + currentMinute);
            wait(sleep);
            return generateCornerEvent(match, team);
        }
    }

    private MatchEvent generateCornerEvent(Match match, Team team) {
        Team defendingTeam = team.equals(match.getHomeTeam()) ? match.getAwayTeam() : match.getHomeTeam();
        int attackQuality = team.getAttackQuality();
        int defenseQuality = defendingTeam.getDefenseQuality();
        int totalQuality = attackQuality + defenseQuality;

        Logger.info("Corner para " + team.getName() + " en el minuto " + currentMinute);
        int chance = random.nextInt(100);
        if (chance < (10 * attackQuality / totalQuality)) {
            Logger.info("Gol en corner para " + team.getName());
            wait(sleep);
            return generateGoalEvent(match, team);
        } else if (chance < (20 * attackQuality / totalQuality)) {
            Logger.info("Corner de nuevo para " + team.getName());
            wait(sleep);
            return generateCornerEvent(match, team);
        } else {
            Logger.info("Corner sin consecuencias para " + team.getName());
            return null;
        }
    }

    private MatchEvent generateGoalEvent(Match match, Team team) {
        MatchEventType matchEventType = matchEventTypeRepository.findById(1L).orElse(null);
        Player scoringPlayer = getRandomPlayer(team);
        if (team.equals(match.getHomeTeam())) {
            match.setGoalsHome(match.getGoalsHome() + 1);
            Logger.info("Gol de " + match.getHomeTeam().getName() + " en el minuto " + currentMinute);
        } else {
            match.setGoalsAway(match.getGoalsAway() + 1);
            Logger.info("Gol de " + match.getAwayTeam().getName() + " en el minuto " + currentMinute);
        }
        if (scoringPlayer != null) {
            scoringPlayer.setGoals(scoringPlayer.getGoals() + 1);
        }
        Logger.info("Resultado: " + match.getGoalsHome() + " - " + match.getGoalsAway());
        return matchEventDao.create(new MatchEvent(null, match, scoringPlayer, team, matchEventType, currentMinute));
    }

    private Player getRandomPlayer(Team team) {
        List<Player> players = playerDao.findPlayersByTeam(team);
        if (players.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(players.size());
        return players.get(randomIndex);
    }

    private Team simulatePenalties(Team homeTeam, Team awayTeam) {
        int homeTeamScore = 0;
        int awayTeamScore = 0;
        int maxRounds = 5;

        for (int i = 0; i < maxRounds; i++) {
            if (random.nextInt(100) < homeTeam.getQuality() - 10) {
                homeTeamScore++;
                Logger.info("Gol de penalti para " + homeTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
            }
            if (random.nextInt(100) < awayTeam.getQuality() - 10) {
                awayTeamScore++;
                Logger.info("Gol de penalti para " + awayTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
            }
        }

        while (homeTeamScore == awayTeamScore) {
            Logger.info("Empate en penaltis, se continúa con la muerte súbita");
            if (random.nextInt(100) < homeTeam.getQuality() - 10) {
                homeTeamScore++;
                Logger.info("Gol de penalti para " + homeTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
            } else if (random.nextInt(100) < awayTeam.getQuality() - 10) {
                awayTeamScore++;
                Logger.info("Gol de penalti para " + awayTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
                break;
            }
            if (random.nextInt(100) < awayTeam.getQuality() - 10) {
                awayTeamScore++;
                Logger.info("Gol de penalti para " + awayTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
            } else if (random.nextInt(100) < homeTeam.getQuality() - 10) {
                homeTeamScore++;
                Logger.info("Gol de penalti para " + homeTeam.getName() + ", " + homeTeamScore + " - " + awayTeamScore);
                break;
            }
        }

        Team winner = homeTeamScore > awayTeamScore ? homeTeam : awayTeam;
        Logger.info("Se acabó la tanda de penaltis! Ganador: " + winner.getName());
        return winner;
    }

    private void wait(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
