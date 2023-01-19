package com.torneo.futbol.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneo.futbol.controller.TeamController;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.service.TeamService;

@RestController
public class TeamControllerImpl implements TeamController {

    @Autowired
    private TeamService teamService;

    @Override
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        return teamService.findById(id);
    }

    @Override
    public void addTeam(Team team) {
        teamService.create(team);
    }

}