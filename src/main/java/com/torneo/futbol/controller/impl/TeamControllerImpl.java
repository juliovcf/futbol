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
@RequestMapping("/api/teams")
public class TeamControllerImpl implements TeamController{

    @Autowired
    private TeamService teamService;
    
    @GetMapping
    @Override
    public ResponseEntity<List<Team>> getTeams() {
        return ResponseEntity.ok(teamService.findAll());
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.findById(id));
    }    

    @Override
    @PostMapping
    public ResponseEntity<Team> createTeam(Team team) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.create(team));
    }

    @Override
    public ResponseEntity<Team> updateTeam(Long id, Team team) {
        return ResponseEntity.ok(teamService.update(id, team));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
