package com.fdp.FDP_SpringBoot.competition;

/**
 * Data Transfer Object (DTO) for detailed information about a competition.
 * It encapsulates various statistics and details about a specific competition.
 */
public class CompetitionDetailsDto {
    // The competition entity with basic competition details.
    private Competition competition;

    // The number of clubs participating in the competition.
    private Long clubCount;

    // The total market value of all clubs in the competition.
    private Double totalMarketValue;

    // The total number of players across all clubs in the competition.
    private Long totalNumberOfPlayers;

    /**
     * Constructor for CompetitionDetailsDto.
     *
     * @param competition The competition entity.
     * @param clubCount The count of clubs in the competition.
     * @param totalNumberOfPlayers The total number of players in the competition.
     * @param totalMarketValue The total market value of the clubs in the competition.
     */
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
