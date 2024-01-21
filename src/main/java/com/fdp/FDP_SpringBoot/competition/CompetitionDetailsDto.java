package com.fdp.FDP_SpringBoot.competition;

public class CompetitionDetailsDto {
    private Competition competition;
    private Long clubCount;

    public CompetitionDetailsDto(Competition competition, Long clubCount) {
        this.competition = competition;
        this.clubCount = clubCount;
    }

    // Getters and setters
}
