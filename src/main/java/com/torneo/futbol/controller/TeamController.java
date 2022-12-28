package com.torneo.futbol.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.torneo.futbol.model.Team;


public interface TeamController {

    ResponseEntity<Team> createTeam(Team team);

    ResponseEntity<List<Team>> getTeams();

    ResponseEntity<Team> getTeamById(Long id);

    ResponseEntity<Team> updateTeam(Long id, Team team);

    ResponseEntity<Void> deleteTeam(Long id);

}