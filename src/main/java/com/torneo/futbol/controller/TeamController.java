package com.torneo.futbol.controller;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.model.Team;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Team Management System")
@RequestMapping("/teams")
public interface TeamController {

    @ApiOperation(value = "View a list of available teams", response = List.class)
    @GetMapping
    List<Team> getAllTeams();

    @GetMapping(value = "/{id}")
    Optional<Team> get(@PathVariable(required = true) Long id);

    @ApiOperation(value = "Add a team")
    @PostMapping
    void addTeam(@ApiParam(value = "Team object store in database table", required = true) @RequestBody Team team);

}