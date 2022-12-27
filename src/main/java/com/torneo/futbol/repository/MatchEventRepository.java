package com.torneo.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.torneo.futbol.model.MatchEvent;

public interface MatchEventRepository  extends JpaRepository<MatchEvent, Long>{
    
}
