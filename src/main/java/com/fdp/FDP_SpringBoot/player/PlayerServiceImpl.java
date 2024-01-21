package com.fdp.FDP_SpringBoot.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Optional<Player> getPlayerById(Integer playerId) {
        // Fetching the player directly
        return playerRepository.findById(playerId);
    }

    @Override
    public List<Player> getAllPlayers() {
        // Fetching all players directly
        return playerRepository.findAll();
    }
}