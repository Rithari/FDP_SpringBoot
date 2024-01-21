package com.fdp.FDP_SpringBoot.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Get a single player by ID
    @GetMapping("/{playerId}")
    public ResponseEntity<?> getPlayerById(@PathVariable Integer playerId) {
        Optional<Player> playerOpt = playerService.getPlayerById(playerId);
        if (playerOpt.isPresent()) {
            return ResponseEntity.ok(playerOpt.get());
        } else {
            return ResponseEntity.status(404).body("Player not found");
        }
    }

    // Get all players
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }
}
