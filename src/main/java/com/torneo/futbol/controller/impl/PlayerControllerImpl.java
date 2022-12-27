package com.torneo.futbol.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneo.futbol.controller.PlayerController;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.service.PlayerService;

@RestController
@RequestMapping("/api")
public class PlayerControllerImpl implements PlayerController{

    @Autowired
    private PlayerService playerService;
    
    @Override
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @Override
    public ResponseEntity<Player> getPlayerById(Long id) {
        Player player = playerService.getPlayerById(id);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }

    @Override
    public ResponseEntity<Player> addPlayer(Player player) {
        return ResponseEntity.ok(playerService.addPlayer(player));
    }

    @Override
    public ResponseEntity<Player> updatePlayer(Long id, Player player) {
        return ResponseEntity.ok(playerService.addPlayer(player));
    }

    @Override
    public ResponseEntity<Void> deletePlayer(Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
    
}
