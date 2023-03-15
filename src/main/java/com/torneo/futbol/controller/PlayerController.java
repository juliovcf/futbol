package com.torneo.futbol.controller;

import java.util.List;

import com.torneo.futbol.dto.CreatePlayerDTO;
import com.torneo.futbol.model.Player;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/players")
public interface PlayerController {

    @GetMapping
    ResponseEntity<List<Player>> getAll();

    @GetMapping(value = "/{id}")
    ResponseEntity<Player> getById(@PathVariable(required = true) Long id);

    @GetMapping("/teams/{teamId}")
    ResponseEntity<List<Player>> findPlayersByTeam(@PathVariable("teamId") Long teamId);

    @PostMapping
    ResponseEntity<Player> add(@RequestBody CreatePlayerDTO player);

    @PutMapping(value = "/{id}")
    ResponseEntity<Player> update(@PathVariable(required = true) Long id, @RequestBody Player player);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable(required = true) Long id);
}
