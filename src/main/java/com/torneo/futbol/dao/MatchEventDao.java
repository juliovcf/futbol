package com.torneo.futbol.dao;

import java.util.Collection;
import java.util.List;

import com.torneo.futbol.model.MatchEvent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchEventDao extends JpaRepository<MatchEvent, Long>{
    
    public List<MatchEvent> getMatchEventsByMatch(Long matchId);

    public Collection<MatchEvent> get(Collection<Long> id );

}
