package com.torneo.futbol.dao;

import java.util.Collection;

import com.torneo.futbol.model.MatchEvent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatchEventDao extends JpaRepository<MatchEvent, Long>{
    
    public Collection<MatchEvent> getByMatchID(Collection<Long> id );

    public Collection<MatchEvent> get(Collection<Long> id );

}
