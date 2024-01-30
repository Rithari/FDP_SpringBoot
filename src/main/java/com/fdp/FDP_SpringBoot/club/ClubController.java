package com.fdp.FDP_SpringBoot.club;

import com.fdp.FDP_SpringBoot.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs() {
        List<Club> clubs = clubService.getAllClubs();
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/{clubId}")
    public ResponseEntity<Club> getClubById(@PathVariable Integer clubId) {
        return clubService.getClubById(clubId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/competition/{competitionId}")
    public ResponseEntity<List<Club>> getClubsByCompetitionId(@PathVariable String competitionId) {
        List<Club> clubs = clubService.getClubsByCompetitionId(competitionId);
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/{clubId}/players")
    public ResponseEntity<List<Player>> getPlayersByClubId(@PathVariable Integer clubId) {
        List<Player> players = clubService.getPlayersByClubId(clubId);
        return ResponseEntity.ok(players);
    }
}
