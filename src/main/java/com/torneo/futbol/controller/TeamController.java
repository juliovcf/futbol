package com.torneo.futbol.controller;

import java.util.List;

import com.torneo.futbol.model.Team;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Team Management System")
@RequestMapping("/teams")
public interface TeamController {

    @ApiOperation(value = "View a list of available teams", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    List<Team> getAllTeams();

    @ApiOperation(value = "Get team by Id")
    @GetMapping(value = "/{id}")
    Team getTeamById(@ApiParam(value = "Team id from which team object will retrieve", required = true) @PathVariable Long id);

    @ApiOperation(value = "Add a team")
    @PostMapping
    void addTeam(@ApiParam(value = "Team object store in database table", required = true) @RequestBody Team team);

}
