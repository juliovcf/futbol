package com.torneo.futbol.controller;

import java.util.List;

import com.torneo.futbol.model.Team;

public interface TeamController {
    List<Team> findAll();

    Team findById(Long id);

    Team save(Team team);

    void delete(Team team);    
}
