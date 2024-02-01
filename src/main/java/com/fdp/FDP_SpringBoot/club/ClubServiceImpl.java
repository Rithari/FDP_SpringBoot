package com.fdp.FDP_SpringBoot.club;

import com.fdp.FDP_SpringBoot.player.Player;
import com.fdp.FDP_SpringBoot.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation for handling club-related business logic.
 * This class implements the ClubService interface.
 */
@Service
public class ClubServiceImpl implements ClubService {

    // Repository for handling player-related data operations.
    @Autowired
    private PlayerRepository playerRepository;

    // Repository for handling club-related data operations.
    private final ClubRepository clubRepository;

    /**
     * Constructor for ClubServiceImpl.
     * Autowired to inject ClubRepository dependency.
     *
     * @param clubRepository The repository to handle club-related data operations.
     */
    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    /**
     * Retrieves all clubs using the ClubRepository.
     *
     * @return A list of all clubs.
     */
    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    /**
     * Retrieves a specific club by its ID using the ClubRepository.
     *
     * @param clubId The ID of the club to be retrieved.
     * @return An Optional containing the club if found, or empty if not.
     */
    @Override
    public Optional<Club> getClubById(Integer clubId) {
        return clubRepository.findById(clubId);
    }

    /**
     * Retrieves clubs based on a competition ID using the ClubRepository.
     *
     * @param competitionId The ID of the competition to match clubs against.
     * @return A list of clubs participating in the specified competition.
     */
    @Override
    public List<Club> getClubsByCompetitionId(String competitionId) {
        return clubRepository.findByDomesticCompetition_CompetitionId(competitionId);
    }

    /**
     * Retrieves players associated with a specific club ID using the PlayerRepository.
     *
     * @param clubId The ID of the club for which players are to be retrieved.
     * @return A list of players currently playing for the specified club.
     */
    @Override
    public List<Player> getPlayersByClubId(Integer clubId) {
        return playerRepository.findByCurrentClubId(clubId);
    }
}
