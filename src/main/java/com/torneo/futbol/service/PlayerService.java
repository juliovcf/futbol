package com.torneo.futbol.service;

import java.util.List;

import com.torneo.futbol.dto.CreatePlayerDTO;
import com.torneo.futbol.model.Player;

public interface PlayerService {

    List<Player> getAll();

    Player getById(Long id);

    Player create(CreatePlayerDTO createPlayerDTO);

    Player update(Long id, Player player);

    void delete(Long id);

    List<Player> findByTeam(Long id);
}
