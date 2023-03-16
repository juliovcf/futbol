package com.torneo.futbol.service.impl;

import java.util.List;

import com.torneo.futbol.dao.PlayerDao;
import com.torneo.futbol.dto.CreatePlayerDTO;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.service.PlayerService;
import com.torneo.futbol.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Player create(CreatePlayerDTO createPlayerDTO) {
        Team team = teamService.findById(createPlayerDTO.getTeamId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid team ID"));

        Player player = new Player();
        player.setTeam(team);
        player.setName(createPlayerDTO.getName());
        player.setSurname(createPlayerDTO.getSurname());
        player.setPosition(createPlayerDTO.getPosition());
        player.setNumber(createPlayerDTO.getNumber());
        player.setGoals(createPlayerDTO.getGoals());
        player.setYellowCards(createPlayerDTO.getYellowCards());
        player.setRedCards(createPlayerDTO.getRedCards());

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
