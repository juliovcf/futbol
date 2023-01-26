package com.torneo.futbol.service;

import java.util.List;

import com.torneo.futbol.model.Player;

public interface PlayerService {

    List<Player> getAllPlayers();

    Player getPlayerById(Long id);

    Player addPlayer(Player player);

    Player updatePlayer(Player player);

    void deletePlayer(Long id);
}
