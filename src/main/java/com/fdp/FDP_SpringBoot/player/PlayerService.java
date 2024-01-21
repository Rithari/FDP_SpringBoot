package com.fdp.FDP_SpringBoot.player;
import java.util.List;
import java.util.Optional;

public interface PlayerService {
    Optional<Player> getPlayerById(Integer playerId);
    List<Player> getAllPlayers();
}
