package com.fdp.FDP_SpringBoot.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    // CRUD methods are inherited from JpaRepository
    // Custom queries will be added here
}
