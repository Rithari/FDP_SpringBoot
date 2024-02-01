package com.fdp.FDP_SpringBoot.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for handling player-related requests.
 * Maps to the '/players' route.
 */
@RestController
@RequestMapping("/players")
public class PlayerController {

    // Service layer that handles business logic related to players.
    @Autowired
    private PlayerService playerService;

    /**
     * Endpoint for retrieving a single player by their ID.
     *
     * @param playerId The ID of the player to be retrieved.
     * @return ResponseEntity with the player data if found, or a 404 status if not found.
     */
    @GetMapping("/{playerId}")
    public ResponseEntity<?> getPlayerById(@PathVariable Integer playerId) {
        Optional<Player> playerOpt = playerService.getPlayerById(playerId);
        if (playerOpt.isPresent()) {
            return ResponseEntity.ok(playerOpt.get());
        } else {
            return ResponseEntity.status(404).body("Player not found");
        }
    }

    /**
     * Endpoint for retrieving all players.
     *
     * @return ResponseEntity with a list of all players.
     */
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }
}
