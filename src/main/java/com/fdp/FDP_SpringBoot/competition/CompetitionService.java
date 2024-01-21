package com.fdp.FDP_SpringBoot.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface CompetitionService {
    List<CompetitionDetailsDto> getAllCompetitions();
    Optional<CompetitionDetailsDto> getCompetitionById(String competitionId);
}

