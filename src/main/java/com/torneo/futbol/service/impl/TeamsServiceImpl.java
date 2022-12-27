package com.torneo.futbol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneo.futbol.model.Team;
import com.torneo.futbol.repository.TeamRepository;
import com.torneo.futbol.service.TeamService;

@Service
public class TeamsServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;
    
    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void delete(Team team) {
        teamRepository.delete(team);
    }
    
}
