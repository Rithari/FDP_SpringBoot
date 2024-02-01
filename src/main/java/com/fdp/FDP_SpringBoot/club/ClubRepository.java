package com.fdp.FDP_SpringBoot.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for Club entities.
 * Extends JpaRepository to provide standard CRUD operations on Club entities.
 */
@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

    /**
     * Custom query to find clubs based on the ID of their domestic competition.
     * Uses JPQL (Java Persistence Query Language) for query definition.
     *
     * @param competitionId The ID of the competition to match clubs against.
     * @return A list of clubs participating in the given competition.
     */
    @Query("SELECT c FROM Club c WHERE c.domesticCompetition.competitionId = :competitionId")
    List<Club> findByDomesticCompetition_CompetitionId(String competitionId);

}
