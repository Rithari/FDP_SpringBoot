package com.fdp.FDP_SpringBoot.competition;

public class CompetitionDetailsDto {
    private Competition competition;
    private Long clubCount;

    private Long totalNumberOfPlayers;

    public Long getTotalNumberOfPlayers() {
        return totalNumberOfPlayers;
    }

    public void setTotalNumberOfPlayers(Long totalNumberOfPlayers) {
        this.totalNumberOfPlayers = totalNumberOfPlayers;
    }

    public CompetitionDetailsDto(Competition competition, Long clubCount, Long totalNumberOfPlayers) {
        this.competition = competition;
        this.clubCount = clubCount;
        this.totalNumberOfPlayers = totalNumberOfPlayers;
    }

    public Competition getCompetition() {
        return competition;
    }

    public Long getClubCount() {
        return clubCount;
    }
}
