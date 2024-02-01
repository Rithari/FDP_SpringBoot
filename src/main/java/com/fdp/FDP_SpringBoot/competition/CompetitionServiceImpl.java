package com.fdp.FDP_SpringBoot.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service implementation for handling competition-related business logic.
 * Implements the CompetitionService interface.
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

    // Repository for handling competition-related data operations.
    @Autowired
    private CompetitionRepository competitionRepository;

    /**
     * Retrieves all competitions and converts them to their DTO representation.
     *
     * @return A list of CompetitionDetailsDto representing all competitions.
     */
    @Override
    public List<CompetitionDetailsDto> getAllCompetitions() {
        return competitionRepository.findAllWithStats()
                .stream()
                .map(this::convertToDtoForAllCompetitions)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves detailed information of a specific competition by its ID.
     * Converts the data to a DTO format if the competition is found.
     *
     * @param competitionId The ID of the competition to retrieve.
     * @return An Optional containing the CompetitionDetailsDto, or empty if not found.
     */
    @Override
    public Optional<CompetitionDetailsDto> getCompetitionById(String competitionId) {
        Optional<Object[]> result = competitionRepository.findByIdWithStats(competitionId);
        if (result.isEmpty()) {
            return Optional.empty();
        }
        return result.map(this::convertToDtoForSingleCompetition);
    }

    /**
     * Retrieves statistical data for a specific competition.
     *
     * @param competitionId The ID of the competition for which statistics are requested.
     * @return A CompetitionStatisticsDto containing the competition's statistics.
     */
    @Override
    public CompetitionStatisticsDto getClubStatisticsByCompetitionId(String competitionId) {
        return competitionRepository.findClubStatisticsByCompetitionId(competitionId);
    }


    /**
     * Converts an array of objects into a CompetitionDetailsDto.
     * This method is a utility for transforming database query results into a more usable format.
     *
     * @param objects The array of objects representing competition data.
     * @return A CompetitionDetailsDto or null if the data is not in the expected format.
     */
    private CompetitionDetailsDto convertToDto(Object[] objects) {
        if (objects != null && objects.length >= 4 && objects[0] instanceof Competition competition) {
            Long clubCount = objects[1] instanceof Number ? ((Number) objects[1]).longValue() : 0;
            Long totalNumberOfPlayers = objects[2] instanceof Number ? ((Number) objects[2]).longValue() : 0;
            Double totalMarketValue = objects[3] instanceof Number ? ((Number) objects[3]).doubleValue() : 0.0;

            return new CompetitionDetailsDto(competition, clubCount, totalNumberOfPlayers, totalMarketValue);
        } else {
            System.out.println("Unexpected data structure: " + Arrays.toString(objects));
            return null;
        }
    }

    /**
     * Converts an array of objects into a CompetitionDetailsDto for all competitions.
     * It's a wrapper around the more general convertToDto method.
     *
     * @param objects The array of objects representing competition data.
     * @return A CompetitionDetailsDto corresponding to the given objects.
     */
    private CompetitionDetailsDto convertToDtoForAllCompetitions(Object[] objects) {
        return convertToDto(objects);
    }

    /**
     * Converts an array of objects into a CompetitionDetailsDto for a single competition.
     * This method is used when fetching details for a specific competition.
     * It ensures that the array contains exactly one nested array of objects before conversion.
     *
     * @param objects The array of objects representing competition data for a single competition.
     * @return A CompetitionDetailsDto if the input is in the expected format, null otherwise.
     */
    private CompetitionDetailsDto convertToDtoForSingleCompetition(Object[] objects) {
        if (objects != null && objects.length == 1 && objects[0] instanceof Object[] nestedObjects) {
            return convertToDto(nestedObjects);
        }

        // Log an error or warning if the data structure is not as expected.
        System.out.println("Returning null from convertToDtoForSingleCompetition");
        return null;
    }

}