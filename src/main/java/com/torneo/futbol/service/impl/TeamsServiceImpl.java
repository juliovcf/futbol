package com.torneo.futbol.service.impl;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.dao.TeamDao;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeamsServiceImpl implements TeamService {

    @Autowired
    private TeamDao teamDao;

    @Override
    public Team create(Team team) {
        return teamDao.create(team);
    }

    @Override
    public List<Team> findAll() {
        return teamDao.findAll();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return teamDao.findById(id);
    }

    @Override
    public Team update(Long id, Team team) {
        team.setId(id);
        return teamDao.update(id, team);
    }

    @Override
    public void delete(Long id) {
        teamDao.delete(id);
    }

}
