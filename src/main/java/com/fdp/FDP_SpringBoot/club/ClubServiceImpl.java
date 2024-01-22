package com.fdp.FDP_SpringBoot.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Optional<Club> getClubById(Integer clubId) {
        return clubRepository.findById(clubId);
    }

    @Override
    public List<Club> getClubsByCompetitionId(String competitionId) {
        return clubRepository.findByDomesticCompetition_CompetitionId(competitionId);
    }
}
