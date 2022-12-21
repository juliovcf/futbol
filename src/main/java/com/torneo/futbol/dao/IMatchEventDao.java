package com.torneo.futbol.dao;

import java.util.Collection;

import com.torneo.futbol.model.MatchEvent;
import org.springframework.data.repository.CrudRepository;

public interface IMatchEventDao extends CrudRepository<MatchEvent, Long>{
    
    public MatchEvent get(Long id);

    public Collection<MatchEvent> getByMatchID(Collection<Long> id );

    public Collection<MatchEvent> get(Collection<Long> id );

}
