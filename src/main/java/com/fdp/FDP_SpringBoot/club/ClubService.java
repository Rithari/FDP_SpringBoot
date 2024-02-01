package com.fdp.FDP_SpringBoot.club;

import com.fdp.FDP_SpringBoot.player.Player;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for club-related operations.
 * This interface defines the business logic for club entities.
 */
public interface ClubService {

    /**
     * Retrieves all clubs.
     *
     * @return A list of all clubs.
     */
    List<Club> getAllClubs();

    /**
     * Retrieves a club by its ID.
     *
     * @param clubId The ID of the club.
     * @return An Optional containing the club if found, or empty if not.
     */
    Optional<Club> getClubById(Integer clubId);

    /**
     * Retrieves clubs participating in a given competition.
     *
     * @param competitionId The ID of the competition.
     * @return A list of clubs in the specified competition.
     */
    List<Club> getClubsByCompetitionId(String competitionId);

    /**
     * Retrieves players belonging to a specific club.
     *
     * @param clubId The ID of the club.
     * @return A list of players in the specified club.
     */
    List<Player> getPlayersByClubId(Integer clubId);
}
