package com.torneo.futbol.controller.impl;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.controller.TeamController;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamControllerImpl implements TeamController {

    @Autowired
    private TeamService teamService;

    @Override
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

    @Override
    public Optional<Team> get(Long id) {
        return teamService.findById(id);
    }

    @Override
    public void addTeam(Team team) {
        teamService.create(team);
    }

}