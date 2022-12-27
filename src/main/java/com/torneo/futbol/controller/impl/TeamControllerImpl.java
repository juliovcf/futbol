package com.torneo.futbol.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.torneo.futbol.controller.TeamController;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.service.TeamService;

public class TeamControllerImpl implements TeamController{

    @Autowired
    private TeamService teamService;
    
    @GetMapping
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public Team findById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @PostMapping
    public Team save(@RequestBody Team team) {
        return teamService.save(team);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(teamService.findById(id));
    }

    @Override
    public void delete(Team team) {
        // TODO Auto-generated method stub
        
    }
    
}
