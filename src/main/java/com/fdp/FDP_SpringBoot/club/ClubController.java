package com.fdp.FDP_SpringBoot.club;

import com.fdp.FDP_SpringBoot.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling requests related to Clubs.
 * Maps to the '/clubs' route.
 */
@RestController
@RequestMapping("/clubs")
public class ClubController {

    // Service layer that handles business logic related to clubs.
    private final ClubService clubService;

    /**
     * Autowired constructor for dependency injection of ClubService.
     *
     * @param clubService The service layer for club-related operations.
     */
    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    /**
     * Retrieves a list of all clubs.
     *
     * @return ResponseEntity containing the list of clubs.
     */
    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs() {
        List<Club> clubs = clubService.getAllClubs();
        return ResponseEntity.ok(clubs);
    }

    /**
     * Retrieves a specific club by its ID.
     *
     * @param clubId The ID of the club to be retrieved.
     * @return ResponseEntity containing the requested club or NotFound status.
     */
    @GetMapping("/{clubId}")
    public ResponseEntity<Club> getClubById(@PathVariable Integer clubId) {
        return clubService.getClubById(clubId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Retrieves a list of clubs participating in a specific competition.
     *
     * @param competitionId The ID of the competition.
     * @return ResponseEntity containing the list of clubs in the specified competition.
     */
    @GetMapping("/competition/{competitionId}")
    public ResponseEntity<List<Club>> getClubsByCompetitionId(@PathVariable String competitionId) {
        List<Club> clubs = clubService.getClubsByCompetitionId(competitionId);
        return ResponseEntity.ok(clubs);
    }

    /**
     * Retrieves a list of players belonging to a specific club.
     *
     * @param clubId The ID of the club.
     * @return ResponseEntity containing the list of players in the specified club.
     */
    @GetMapping("/{clubId}/players")
    public ResponseEntity<List<Player>> getPlayersByClubId(@PathVariable Integer clubId) {
        List<Player> players = clubService.getPlayersByClubId(clubId);
        return ResponseEntity.ok(players);
    }
}
