package com.torneo.futbol.service.impl;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.model.Team;
import com.torneo.futbol.repository.TeamRepository;
import com.torneo.futbol.service.TeamService;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeamsServiceImpl implements TeamService {

    Logger log;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team create(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(Long id) {
        log.info("Lanzando findById");
        return teamRepository.findById(id);
    }

    @Override
    public Team update(Long id, Team team) {
        team.setId(id);
        return teamRepository.save(team);
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

}
