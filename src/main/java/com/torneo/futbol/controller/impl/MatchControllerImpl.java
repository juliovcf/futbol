package com.torneo.futbol.controller.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.torneo.futbol.controller.MatchController;
import com.torneo.futbol.model.Match;
import com.torneo.futbol.service.MatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchControllerImpl implements MatchController {

    @Autowired
    private MatchService matchService;

    @Override
    public ResponseEntity<List<Match>> getAll() {
        return ResponseEntity.ok(matchService.findAll());
    }

    @Override
    public ResponseEntity<Match> getById(Long id) {
        Match match = matchService.findById(id);
        if (match == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(match);
    }

    @Override
    public ResponseEntity<List<Match>> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        List<Match> matches = matchService.findByDateBetween(startDate, endDate);
        return ResponseEntity.ok(matches);
    }

    @Override
    public ResponseEntity<Match> create(Match match) {
        return ResponseEntity.ok(matchService.create(match));
    }

    @Override
    public ResponseEntity<String> simulateMatch(Long matchId) {
        Match match = matchService.findById(matchId);

        if (match == null) {
            return ResponseEntity.badRequest().body("Match not found");
        }

        if (match.isPlayed()) {
            return ResponseEntity.badRequest().body("Match already played");
        }

        matchService.simulateMatch(match);
        return ResponseEntity.ok("Match simulated successfully");
    }
}
