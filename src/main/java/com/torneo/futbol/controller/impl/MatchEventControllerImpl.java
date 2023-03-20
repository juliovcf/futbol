 package com.torneo.futbol.controller.impl;

 import com.torneo.futbol.controller.MatchEventController;
 import com.torneo.futbol.model.MatchEvent;
 import com.torneo.futbol.service.MatchEventService;
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.DeleteMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestController;
 
 @RestController
 public class MatchEventControllerImpl implements MatchEventController {
 
     @Autowired
     private MatchEventService matchEventService;
 
     @Override
     @GetMapping
     public ResponseEntity<List<MatchEvent>> getAll() {
         List<MatchEvent> matchEvents = matchEventService.getAll();
         return ResponseEntity.ok(matchEvents);
     }
 
     @Override
     @GetMapping("/{id}")
     public ResponseEntity<MatchEvent> getById(@PathVariable Long id) {
         MatchEvent matchEvent = matchEventService.getById(id).orElse(null);
         if (matchEvent == null) {
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(matchEvent);
     }
 
     @Override
     @PostMapping
     public ResponseEntity<MatchEvent> create(@RequestBody MatchEvent matchEvent) {
         MatchEvent createdMatchEvent = matchEventService.create(matchEvent);
         return ResponseEntity.ok(createdMatchEvent);
     }
 
     @Override
     @PutMapping("/{id}")
     public ResponseEntity<MatchEvent> update(@PathVariable Long id, @RequestBody MatchEvent matchEvent) {
         MatchEvent updatedMatchEvent = matchEventService.update(id, matchEvent);
         return ResponseEntity.ok(updatedMatchEvent);
     }
 
     @Override
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> delete(@PathVariable Long id) {
         matchEventService.delete(id);
         return ResponseEntity.noContent().build();
     }
 
     @Override
     @GetMapping("/matches/{matchId}")
     public ResponseEntity<List<MatchEvent>> getByMatchID(@PathVariable Long matchId) {
         List<MatchEvent> matchEvents = matchEventService.getByMatchID(matchId);
         return ResponseEntity.ok(matchEvents);
     }
 }
 