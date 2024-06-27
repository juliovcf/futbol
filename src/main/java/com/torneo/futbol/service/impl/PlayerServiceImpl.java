package com.torneo.futbol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneo.futbol.dao.PlayerDao;
import com.torneo.futbol.dto.PlayerDTO;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.service.PlayerService;
import com.torneo.futbol.service.TeamService;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private TeamService teamService;

    @Override
    public List<Player> getAll() {
        return playerDao.findAll();
    }

    @Override
    public Player getById(Long id) {
        return playerDao.findById(id).orElse(null);
    }

    @Override
    public Player create(PlayerDTO PlayerDTO) {
        Team team = teamService.findById(PlayerDTO.getTeamId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid team ID"));

        Player player = new Player();
        player.setTeam(team);
        player.setName(PlayerDTO.getName());
        player.setSurname(PlayerDTO.getSurname());
        player.setPosition(PlayerDTO.getPosition());
        player.setNumber(PlayerDTO.getNumber());
        player.setGoals(PlayerDTO.getGoals());
        player.setYellowCards(PlayerDTO.getYellowCards());
        player.setRedCards(PlayerDTO.getRedCards());

        return playerDao.create(player);
    }

    @Override
    public Player update(Long id, Player player) {
        player.setId(id);
        return playerDao.update(id, player);
    }

    @Override
    public void delete(Long id) {
        playerDao.delete(id);
    }

    @Override
    public List<Player> findByTeam(Long id) {
        Team team = teamService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid team ID"));
        return playerDao.findPlayersByTeam(team);
    }

}
