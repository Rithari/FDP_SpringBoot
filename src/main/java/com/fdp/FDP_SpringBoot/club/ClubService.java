package com.fdp.FDP_SpringBoot.club;

import com.fdp.FDP_SpringBoot.player.Player;

import java.util.List;
import java.util.Optional;

public interface ClubService {
    List<Club> getAllClubs();
    Optional<Club> getClubById(Integer clubId);

    List<Club> getClubsByCompetitionId(String competitionId);

    List<Player> getPlayersByClubId(Integer clubId);
}
