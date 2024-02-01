package com.fdp.FDP_SpringBoot.player;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for player-related operations.
 * Defines the business logic for handling and retrieving player data.
 */
public interface PlayerService {

    /**
     * Retrieves a player by their ID.
     *
     * @param playerId The ID of the player to be retrieved.
     * @return An Optional containing the player if found, or empty if not found.
     */
    Optional<Player> getPlayerById(Integer playerId);

    /**
     * Retrieves all players.
     *
     * @return A list of all players.
     */
    List<Player> getAllPlayers();
}
