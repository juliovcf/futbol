package com.torneo.futbol.dao;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.model.Team;

public interface TeamDao {
    
    Team create(Team team);

    List<Team> findAll();

    Optional<Team> findById(Long id);

    Team update(Long id, Team team);

    void delete(Long id);
}
