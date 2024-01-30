package com.fdp.FDP_SpringBoot.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByCurrentClubId(Integer currentClubId);

}
