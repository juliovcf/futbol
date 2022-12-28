package com.torneo.futbol.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torneo.futbol.model.Team;

public interface TeamDao extends JpaRepository <Team, Long>{
    
}
