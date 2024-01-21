package com.fdp.FDP_SpringBoot.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String> {

    @Query("SELECT c, COUNT(cl), SUM(cl.squadSize) FROM Competition c LEFT JOIN c.clubs cl GROUP BY c")
    List<Object[]> findAllWithStats();


    @Query("SELECT c, COUNT(cl), SUM(cl.squadSize) FROM Competition c LEFT JOIN c.clubs cl WHERE c.competitionId = :competitionId GROUP BY c")
    Optional<Object[]> findByIdWithStats(String competitionId);

}
