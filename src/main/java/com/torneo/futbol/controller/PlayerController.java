
package com.torneo.futbol.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torneo.futbol.model.Player;

@RequestMapping("/players")
public interface PlayerController {

    @GetMapping
    ResponseEntity<List<Player>> getAllPlayers();

    @GetMapping(value = "/{id}")
    ResponseEntity<Player> getPlayerById(@PathVariable(required = true) Long id);

    @PostMapping
    ResponseEntity<Player> addPlayer(@RequestBody Player player);

    @PutMapping(value = "/{id}")
    ResponseEntity<Player> updatePlayer(@PathVariable(required = true) Long id, @RequestBody Player player);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deletePlayer(@PathVariable(required = true) Long id);
}
