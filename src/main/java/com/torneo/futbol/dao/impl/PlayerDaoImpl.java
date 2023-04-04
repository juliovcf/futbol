package com.torneo.futbol.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.torneo.futbol.dao.PlayerDao;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public Player update(Long id, Player player) {
        player.setId(id);
        return playerRepository.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> findPlayersByTeam(Team team) {
        List<Player> players = playerRepository.findByTeam(team);
    
        if (players == null) {
            players = new ArrayList<>();
        }
    
        return players;
    }
    

}
