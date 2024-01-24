package com.fdp.FDP_SpringBoot.competition;

public class CompetitionStatisticsDto {

    private String competitionId;
    private Double averageAge;
    private Double averageForeignersPercentage;
    private Double averageMarketValue;
    private long totalForeigners;

    public long getTotalForeigners() {
        return totalForeigners;
    }

    public void setTotalForeigners(long totalForeigners) {
        this.totalForeigners = totalForeigners;
    }

    public CompetitionStatisticsDto(String competitionId, Double averageAge, Double averageForeignersPercentage, Double averageMarketValue, long totalForeigners) {
        this.competitionId = competitionId;
        this.averageAge = averageAge;
        this.averageForeignersPercentage = averageForeignersPercentage;
        this.averageMarketValue = averageMarketValue;
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
