package com.torneo.futbol.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torneo.futbol.model.Player;

public interface PlayerDao extends JpaRepository<Player, Long>{
    
}
