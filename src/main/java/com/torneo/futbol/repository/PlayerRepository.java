package com.torneo.futbol.repository;

import com.torneo.futbol.model.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
