package com.torneo.futbol.dao;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;

public interface PlayerDao {
    
    Player create(Player player);

    List<Player> findAll();

    Optional<Player> findById(Long id);

    Player update(Long id, Player player);

    void delete(Long id);
    
    List<Player> findPlayersByTeam(Team team);
}
