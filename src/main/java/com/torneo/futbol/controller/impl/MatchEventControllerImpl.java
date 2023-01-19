/*package com.torneo.futbol.controller.impl;

import java.util.Collection;
import java.util.List;

import com.torneo.futbol.controller.MatchEventController;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.service.impl.MatchEventService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matchEvents")
public class MatchEventControllerImpl implements MatchEventController {

    private MatchEventService matchEventService;

    @Override
    public ResponseEntity<MatchEvent> get(Long id) {
        MatchEvent event = matchEventService.get(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
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

    
}*/