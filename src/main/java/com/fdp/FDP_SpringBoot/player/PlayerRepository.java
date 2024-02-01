package com.fdp.FDP_SpringBoot.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Player entities.
 * Extends JpaRepository to provide standard CRUD operations on Player entities.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    /**
     * Custom query method to find players based on their current club ID.
     * This method fetches all players who are currently associated with a specific club.
     *
     * @param currentClubId The ID of the club to match players against.
     * @return A list of players who are currently in the specified club.
     */
    List<Player> findByCurrentClubId(Integer currentClubId);
}
