package com.torneo.futbol.service;

import java.util.List;

import com.torneo.futbol.model.Team;

public interface TeamService {
    
    Team create(Team team);

    List<Team> findAll();

    Team findById(Long id);

    Team update(Long id, Team team);

    void delete(Long id);
}
