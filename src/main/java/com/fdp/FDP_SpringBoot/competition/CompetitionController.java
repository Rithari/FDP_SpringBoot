package com.fdp.FDP_SpringBoot.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public ResponseEntity<List<CompetitionDetailsDto>> getAllCompetitions() {
        List<CompetitionDetailsDto> competitions = competitionService.getAllCompetitions();
        return ResponseEntity.ok(competitions);
    }

    @GetMapping("/{competitionId}")
    public ResponseEntity<CompetitionDetailsDto> getCompetitionById(@PathVariable String competitionId) {
        return competitionService.getCompetitionById(competitionId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
