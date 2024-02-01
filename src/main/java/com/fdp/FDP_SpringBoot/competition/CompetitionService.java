package com.fdp.FDP_SpringBoot.competition;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for competition-related operations.
 * Defines the business logic for handling and retrieving competition data.
 */
public interface CompetitionService {

    /**
     * Retrieves all competitions along with their detailed information.
     *
     * @return A list of CompetitionDetailsDto containing details of all competitions.
     */
    List<CompetitionDetailsDto> getAllCompetitions();

    /**
     * Retrieves detailed information of a specific competition by its ID.
     *
     * @param competitionId The ID of the competition to retrieve.
     * @return An Optional containing the CompetitionDetailsDto if found, or empty if not.
     */
    Optional<CompetitionDetailsDto> getCompetitionById(String competitionId);

    /**
     * Retrieves statistical data for a specific competition.
     *
     * @param competitionId The ID of the competition for which statistics are requested.
     * @return A CompetitionStatisticsDto object containing aggregated statistical data of the competition.
     */
    CompetitionStatisticsDto getClubStatisticsByCompetitionId(String competitionId);
}
