package com.torneo.futbol.repository;

import com.torneo.futbol.model.MatchEvent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchEventRepository extends JpaRepository<MatchEvent, Long> {

}
