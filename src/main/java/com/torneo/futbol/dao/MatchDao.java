package com.torneo.futbol.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torneo.futbol.model.Match;

public interface MatchDao extends JpaRepository<Match, Long>{
    
}
