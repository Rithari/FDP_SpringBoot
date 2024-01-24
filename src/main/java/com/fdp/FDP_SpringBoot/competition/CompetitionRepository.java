package com.fdp.FDP_SpringBoot.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String> {

        @Query("SELECT c, COUNT(cl), SUM(cl.squadSize), " +
                "(SELECT SUM(p.marketValueInEur) FROM Player p WHERE p.currentClub IN (SELECT cl FROM Club cl WHERE cl.domesticCompetition = c)) " +
                "FROM Competition c " +
                "LEFT JOIN c.clubs cl " +
                "GROUP BY c")
        List<Object[]> findAllWithStats();


    @Query("SELECT c, COUNT(cl), SUM(cl.squadSize), " +
            "(SELECT SUM(p.marketValueInEur) FROM Player p WHERE p.currentClub IN (SELECT cl FROM Club cl WHERE cl.domesticCompetition = c)) " +
            "FROM Competition c " +
            "LEFT JOIN c.clubs cl " +
            "WHERE c.competitionId = :competitionId " +
            "GROUP BY c")
    Optional<Object[]> findByIdWithStats(String competitionId);

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
