package com.torneo.futbol.controller;

import com.torneo.futbol.model.MatchEvent;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/match-events")
public interface MatchEventController {

    ResponseEntity<List<MatchEvent>> getAll();

    ResponseEntity<MatchEvent> getById(@PathVariable Long id);

    ResponseEntity<MatchEvent> create(@RequestBody MatchEvent matchEvent);

    ResponseEntity<MatchEvent> update(@PathVariable Long id, @RequestBody MatchEvent matchEvent);

    ResponseEntity<Void> delete(@PathVariable Long id);

    ResponseEntity<List<MatchEvent>> getByMatchID(@PathVariable Long matchId);
}
