package com.torneo.futbol.repository;

import java.util.List;

import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeam(Team team);
}
