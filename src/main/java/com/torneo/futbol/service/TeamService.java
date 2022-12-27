package com.torneo.futbol.service;

import java.util.List;

import com.torneo.futbol.model.Team;

public interface TeamService {
    
    List<Team> findAll();

    Team findById(Long id);

    Team save(Team team);

    void delete(Team team);
}
