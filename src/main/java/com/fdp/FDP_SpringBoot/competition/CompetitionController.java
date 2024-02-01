package com.fdp.FDP_SpringBoot.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for handling requests related to Competitions.
 * Maps to the '/competitions' route.
 */
@RestController
@RequestMapping("/competitions")
public class CompetitionController {

    // Service layer that handles business logic related to competitions.
    @Autowired
    private CompetitionService competitionService;

    /**
     * Retrieves a list of all competition details.
     *
     * @return ResponseEntity containing the list of competition details.
     */
    @GetMapping
    public ResponseEntity<List<CompetitionDetailsDto>> getAllCompetitions() {
        List<CompetitionDetailsDto> competitions = competitionService.getAllCompetitions();
        return ResponseEntity.ok(competitions);
    }

    /**
     * Retrieves details of a specific competition by its ID.
     *
     * @param competitionId The ID of the competition to be retrieved.
     * @return ResponseEntity containing the competition details or NotFound status.
     */
    @GetMapping("/{competitionId}")
    public ResponseEntity<CompetitionDetailsDto> getCompetitionById(@PathVariable String competitionId) {
        Optional<CompetitionDetailsDto> competitionDto = competitionService.getCompetitionById(competitionId);
        return competitionDto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Retrieves statistical data for a specific competition.
     *
     * @param competitionId The ID of the competition for which statistics are requested.
     * @return ResponseEntity containing the competition statistics or NotFound status.
     */
    @GetMapping("/{competitionId}/statistics")
    public ResponseEntity<CompetitionStatisticsDto> getCompetitionStatistics(@PathVariable String competitionId) {
        CompetitionStatisticsDto clubStatistics = competitionService.getClubStatisticsByCompetitionId(competitionId);
        if (clubStatistics != null) {
            return ResponseEntity.ok(clubStatistics);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
