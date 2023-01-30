/*
 * package com.torneo.futbol.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody;
 * 
 * import com.torneo.futbol.model.Player;
 * 
 * public interface PlayerController {
 * 
 * @GetMapping("/players") ResponseEntity<List<Player>> getAllPlayers();
 * 
 * @GetMapping("/players/{id}") ResponseEntity<Player>
 * getPlayerById(@PathVariable(required = true) Long id);
 * 
 * @PostMapping("/players") ResponseEntity<Player> addPlayer(@RequestBody Player
 * player);
 * 
 * @PutMapping("/players/{id}") ResponseEntity<Player>
 * updatePlayer(@PathVariable(required = true) Long id, @RequestBody Player
 * player);
 * 
 * @DeleteMapping("/players/{id}") ResponseEntity<Void>
 * deletePlayer(@PathVariable(required = true) Long id); }
 */