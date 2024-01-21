package com.fdp.FDP_SpringBoot.club;

import java.util.List;
import java.util.Optional;

public interface ClubService {
    List<Club> getAllClubs();
    Optional<Club> getClubById(Integer clubId);
}
