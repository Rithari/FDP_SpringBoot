package com.fdp.FDP_SpringBoot.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Override
    public List<CompetitionDetailsDto> getAllCompetitions() {
        return competitionRepository.findAllWithStats()
                .stream()
                .map(this::convertToDtoForAllCompetitions)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CompetitionDetailsDto> getCompetitionById(String competitionId) {
        System.out.println("Service: Finding competition with ID: " + competitionId);
        Optional<Object[]> result = competitionRepository.findByIdWithStats(competitionId);
        if (result.isEmpty()) {
            System.out.println("Service: No competition found for ID: " + competitionId);
            return Optional.empty();
        }
        System.out.println("Service: Found competition, converting to DTO");
        return result.map(this::convertToDtoForSingleCompetition);
    }

    private CompetitionDetailsDto convertToDto(Object[] objects) {
        if (objects != null && objects.length >= 4 && objects[0] instanceof Competition competition) {
            Long clubCount = objects[1] instanceof Number ? ((Number) objects[1]).longValue() : 0;
            Long totalNumberOfPlayers = objects[2] instanceof Number ? ((Number) objects[2]).longValue() : 0;
            Double totalMarketValue = objects[3] instanceof Number ? ((Number) objects[3]).doubleValue() : 0.0;

            return new CompetitionDetailsDto(competition, clubCount, totalNumberOfPlayers, totalMarketValue);
        } else {
            // Log for debugging
            System.out.println("Unexpected data structure: " + Arrays.toString(objects));
            return null;
        }
    }

    private CompetitionDetailsDto convertToDtoForAllCompetitions(Object[] objects) {
        return convertToDto(objects);
    }

    private CompetitionDetailsDto convertToDtoForSingleCompetition(Object[] objects) {
        if (objects != null && objects.length == 1 && objects[0] instanceof Object[] nestedObjects) {
            return convertToDto(nestedObjects);
        }

        System.out.println("Returning null from convertToDtoForSingleCompetition");
        return null;
    }
}