package com.fdp.FDP_SpringBoot.competition;

public class CompetitionStatisticsDto {
    // Unique identifier of the competition.
    private String competitionId;

    // The average age of players across all clubs in the competition.
    private Double averageAge;

    // The average percentage of foreign players across all clubs in the competition.
    private Double averageForeignersPercentage;

    // The average market value of players across all clubs in the competition.
    private Double averageMarketValue;

    // The total number of foreign players across all clubs in the competition.
    private long totalForeigners;

    /**
     * Constructor for CompetitionStatisticsDto.
     *
     * @param competitionId The identifier of the competition.
     * @param averageAge The average age of players in the competition.
     * @param averageForeignersPercentage The average percentage of foreign players.
     * @param averageMarketValue The average market value of players.
     * @param totalForeigners The total number of foreign players in the competition.
     */
    public CompetitionStatisticsDto(String competitionId, Double averageAge, Double averageForeignersPercentage, Double averageMarketValue, long totalForeigners) {
        this.competitionId = competitionId;
        this.averageAge = averageAge;
        this.averageForeignersPercentage = averageForeignersPercentage;
        this.averageMarketValue = averageMarketValue;
        this.totalForeigners = totalForeigners;
    }

    public long getTotalForeigners() {
        return totalForeigners;
    }

    public void setTotalForeigners(long totalForeigners) {
        this.totalForeigners = totalForeigners;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public Double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(Double averageAge) {
        this.averageAge = averageAge;
    }

    public Double getAverageForeignersPercentage() {
        return averageForeignersPercentage;
    }

    public void setAverageForeignersPercentage(Double averageForeignersPercentage) {
        this.averageForeignersPercentage = averageForeignersPercentage;
    }

    public Double getAverageMarketValue() {
        return averageMarketValue;
    }

    public void setAverageMarketValue(Double averageMarketValue) {
        this.averageMarketValue = averageMarketValue;
    }
}
