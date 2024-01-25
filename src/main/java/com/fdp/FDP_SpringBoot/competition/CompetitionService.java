package com.fdp.FDP_SpringBoot.competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionService {
    List<CompetitionDetailsDto> getAllCompetitions();
    Optional<CompetitionDetailsDto> getCompetitionById(String competitionId);

    CompetitionStatisticsDto getClubStatisticsByCompetitionId(String competitionId);
}

