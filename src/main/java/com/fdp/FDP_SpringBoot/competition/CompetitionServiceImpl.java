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




    private CompetitionDetailsDto convertToDtoForAllCompetitions(Object[] objects) {
        if (objects != null && objects.length >= 2 && objects[0] instanceof Competition) {
            Competition competition = (Competition) objects[0];
            Long clubCount = objects.length > 1 && objects[1] instanceof Number ? ((Number) objects[1]).longValue() : 0;
            Long totalNumberOfPlayers = objects.length > 2 && objects[2] instanceof Number ? ((Number) objects[2]).longValue() : 0;
            return new CompetitionDetailsDto(competition, clubCount, totalNumberOfPlayers);
        } else {
            // Log for debugging
            System.out.println("Unexpected data structure: " + Arrays.toString(objects));
            return null;
        }
    }


    private CompetitionDetailsDto convertToDtoForSingleCompetition(Object[] objects) {
        if (objects != null) {
            System.out.println("Converting DTO for single competition. Array length: " + objects.length);

            // Handle the case when only one Object[] is returned
            if (objects.length == 1 && objects[0] instanceof Object[]) {
                Object[] nestedObjects = (Object[]) objects[0];
                if (nestedObjects.length == 3 && nestedObjects[0] instanceof Competition && nestedObjects[1] instanceof Number && nestedObjects[2] instanceof Number) {
                    Competition competition = (Competition) nestedObjects[0];
                    Long clubCount = ((Number) nestedObjects[1]).longValue();
                    Long totalNumberOfPlayers = ((Number) nestedObjects[2]).longValue();
                    return new CompetitionDetailsDto(competition, clubCount, totalNumberOfPlayers);
                }
            }
        }
        System.out.println("Returning null from convertToDtoForSingleCompetition");
        return null;
    }

}
