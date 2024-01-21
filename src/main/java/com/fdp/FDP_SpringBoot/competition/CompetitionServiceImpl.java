package com.fdp.FDP_SpringBoot.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Override
    public List<CompetitionDetailsDto> getAllCompetitions() {
        return competitionRepository.findAllCompetitionsWithClubCount()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CompetitionDetailsDto> getCompetitionById(String competitionId) {
        return competitionRepository.findCompetitionWithClubCountById(competitionId)
                .map(this::convertToDto);
    }

    private CompetitionDetailsDto convertToDto(Object[] objects) {
        Competition competition = (Competition) objects[0];
        Long clubCount = (Long) objects[1];
        return new CompetitionDetailsDto(competition, clubCount);
    }
}
