package com.torneo.futbol.controller.impl;

import java.util.Collection;
import java.util.List;

import com.torneo.futbol.controller.IMatchEventController;
import com.torneo.futbol.model.MatchEvent;

import org.springframework.http.ResponseEntity;

public class MatchEventController implements IMatchEventController {

    @Override
    public ResponseEntity<MatchEvent> get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<List<MatchEvent>> get(Collection<Long> lId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<MatchEvent> getByMatchID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    
}