package com.fdp.FDP_SpringBoot.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

    @Query("SELECT c FROM Club c WHERE c.domesticCompetition.competitionId = :competitionId")
    List<Club> findByDomesticCompetition_CompetitionId(String competitionId);

}
