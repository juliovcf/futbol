package com.torneo.futbol.controller.impl;

import java.util.List;

import com.torneo.futbol.controller.PlayerController;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerControllerImpl implements PlayerController {

    @Autowired
    private PlayerService playerService;

    @Override
    public ResponseEntity<List<Player>> getAll() {
        return ResponseEntity.ok(playerService.getAll());
    }

    @Override
    public ResponseEntity<Player> getById(Long id) {
        Player player = playerService.getById(id);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }

    @Override
    public ResponseEntity<List<Player>> findPlayersByTeam(Long teamId) {
        List<Player> players = playerService.findByTeam(teamId);
        return ResponseEntity.ok(players);
    }

    @Override
    public ResponseEntity<Player> add(Player player) {
        return ResponseEntity.ok(playerService.create(player));
    }

    @Override
    public ResponseEntity<Player> update(Long id, Player player) {
        return ResponseEntity.ok(playerService.update(id, player));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
