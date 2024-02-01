package com.fdp.FDP_SpringBoot.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Competition entities.
 * Extends JpaRepository to provide standard CRUD operations on Competition entities.
 */
@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String> {

    /**
     * Custom query to retrieve competition statistics along with basic competition details.
     * Returns an array of objects containing the competition, club count, total squad size, and total market value.
     *
     * @return A list of Object arrays where each array contains competition details and statistics.
     */
    @Query("SELECT c, COUNT(cl), SUM(cl.squadSize), " +
            "(SELECT SUM(p.marketValueInEur) FROM Player p WHERE p.currentClub IN (SELECT cl FROM Club cl WHERE cl.domesticCompetition = c)) " +
            "FROM Competition c " +
            "LEFT JOIN c.clubs cl " +
            "GROUP BY c")
    List<Object[]> findAllWithStats();

    /**
     * Custom query similar to findAllWithStats but for a specific competition ID.
     * Returns an array of objects containing the competition, club count, total squad size, and total market value.
     *
     * @param competitionId The ID of the competition to fetch statistics for.
     * @return An Optional containing an Object array with competition details and statistics, or empty if not found.
     */
    @Query("SELECT c, COUNT(cl), SUM(cl.squadSize), " +
            "(SELECT SUM(p.marketValueInEur) FROM Player p WHERE p.currentClub IN (SELECT cl FROM Club cl WHERE cl.domesticCompetition = c)) " +
            "FROM Competition c " +
            "LEFT JOIN c.clubs cl " +
            "WHERE c.competitionId = :competitionId " +
            "GROUP BY c")
    Optional<Object[]> findByIdWithStats(String competitionId);

    /**
     * Custom query to retrieve average statistics of clubs participating in a specific competition.
     * Constructs a CompetitionStatisticsDto with aggregated statistical data.
     *
     * @param competitionId The ID of the competition for which club statistics are requested.
     * @return A CompetitionStatisticsDto object containing aggregated statistics of clubs in the competition.
     */
    @Query("SELECT new com.fdp.FDP_SpringBoot.competition.CompetitionStatisticsDto(" +
            "c.domesticCompetition.competitionId, " +
            "AVG(nullif(c.averageAge, 'NaN')), " +
            "AVG(nullif(c.foreignersPercentage, 'NaN')), " +
            "(SELECT AVG(p.marketValueInEur) FROM Player p WHERE p.currentClub.domesticCompetition.competitionId = c.domesticCompetition.competitionId), " +
            "SUM(c.foreignersNumber)" +
            ") " +
            "FROM Club c " +
            "WHERE c.domesticCompetition.competitionId = :competitionId " +
            "GROUP BY c.domesticCompetition.competitionId")
    CompetitionStatisticsDto findClubStatisticsByCompetitionId(String competitionId);

}
