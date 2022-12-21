package com.torneo.futbol.controller;

import java.util.Collection;
import java.util.List;

import com.torneo.futbol.model.MatchEvent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface IMatchEventController {
    
    @GetMapping("/{id}")
    public ResponseEntity<MatchEvent> get(@PathVariable(required = true) Long id);
    
    @GetMapping("/match/{matchID}")
    public ResponseEntity<MatchEvent> getByMatchID(@PathVariable(required = true) Long id);

    @GetMapping
    public ResponseEntity<List<MatchEvent>> get(@RequestParam(required = false) Collection<Long> lId);

}
