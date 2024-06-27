package com.torneo.futbol.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.torneo.futbol.model.Match;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/matches")
public interface MatchController {

    @GetMapping
    ResponseEntity<List<Match>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<Match> getById(@PathVariable Long id);

    @GetMapping("/search")
    ResponseEntity<List<Match>> findByDateBetween(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate);

    @PostMapping
    ResponseEntity<Match> create(@RequestBody Match match);

    @PostMapping("/simulate-match")
    ResponseEntity<String> simulateMatch(@RequestParam Long matchId);
}
