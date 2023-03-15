package com.torneo.futbol.controller;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.model.Team;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiParam;

@RequestMapping("/teams")
public interface TeamController {

    @GetMapping
    List<Team> getAllTeams();

    @GetMapping(value = "/{id}")
    Optional<Team> get(@PathVariable(required = true) Long id);

    @PostMapping
    void addTeam(@ApiParam(required = true) @RequestBody Team team);

    @DeleteMapping("/{id}")
    void deleteTeam(@ApiParam(required = true) @PathVariable(value = "id") Long id);

}
