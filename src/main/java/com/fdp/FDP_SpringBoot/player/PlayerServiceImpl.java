package com.fdp.FDP_SpringBoot.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation for handling player-related business logic.
 * Implements the PlayerService interface.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    /**
     * Retrieves a specific player by their ID using the PlayerRepository.
     *
     * @param playerId The ID of the player to be retrieved.
     * @return An Optional containing the player if found, or empty if not found.
     */
    @Override
    public Optional<Player> getPlayerById(Integer playerId) {
        return playerRepository.findById(playerId);
    }

    /**
     * Retrieves all players using the PlayerRepository.
     *
     * @return A list of all players.
     */
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}