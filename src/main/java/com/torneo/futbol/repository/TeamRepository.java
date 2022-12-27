package com.torneo.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torneo.futbol.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{
    
}
