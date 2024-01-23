package com.fdp.FDP_SpringBoot.competition;

public class CompetitionDetailsDto {
    private Competition competition;
    private Long clubCount;

    private Double totalMarketValue;
    private Long totalNumberOfPlayers;

    public CompetitionDetailsDto(Competition competition, Long clubCount, Long totalNumberOfPlayers, Double totalMarketValue) {
        this.competition = competition;
        this.clubCount = clubCount;
        this.totalNumberOfPlayers = totalNumberOfPlayers;
        this.totalMarketValue = totalMarketValue;
    }
    public Long getTotalNumberOfPlayers() {
        return totalNumberOfPlayers;
    }

    public void setTotalNumberOfPlayers(Long totalNumberOfPlayers) {
        this.totalNumberOfPlayers = totalNumberOfPlayers;
    }

    public Competition getCompetition() {
        return competition;
    }

    public Long getClubCount() {
        return clubCount;
    }

    public Double getTotalMarketValue() {
        return totalMarketValue;
    }

    public void setTotalMarketValue(Double totalMarketValue) {
        this.totalMarketValue = totalMarketValue;
    }
}
