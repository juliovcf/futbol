package com.torneo.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torneo.futbol.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{
    
}
