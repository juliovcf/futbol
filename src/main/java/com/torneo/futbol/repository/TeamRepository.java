package com.torneo.futbol.repository;

import com.torneo.futbol.model.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
