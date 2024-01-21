package com.fdp.FDP_SpringBoot.club;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fdp.FDP_SpringBoot.competition.Competition;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @Column(name = "club_id", nullable = false)
    private Integer clubId;

    @Column(name = "club_code", length = 255)
    private String clubCode;

    @Column(name = "name", length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "domestic_competition_id")
    @JsonBackReference
    private Competition domesticCompetition;

    @Column(name = "squad_size")
    private Integer squadSize;

    @Column(name = "average_age")
    private Double averageAge;

    @Column(name = "foreigners_number")
    private Integer foreignersNumber;

    @Column(name = "foreigners_percentage")
    private Double foreignersPercentage;

    @Column(name = "national_team_players")
    private Integer nationalTeamPlayers;

    @Column(name = "stadium_name", length = 255)
    private String stadiumName;

    @Column(name = "stadium_seats")
    private Integer stadiumSeats;

    @Column(name = "net_transfer_record")
    private Double netTransferRecord;

    @Column(name = "last_season")
    private Integer lastSeason;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;


    // Constructors
    public Club() {
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getClubCode() {
        return clubCode;
    }

    public void setClubCode(String clubCode) {
        this.clubCode = clubCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Competition getDomesticCompetition() {
        return domesticCompetition;
    }

    public void setDomesticCompetition(Competition domesticCompetition) {
        this.domesticCompetition = domesticCompetition;
    }

    public Integer getSquadSize() {
        return squadSize;
    }

    public void setSquadSize(Integer squadSize) {
        this.squadSize = squadSize;
    }

    public Double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(Double averageAge) {
        this.averageAge = averageAge;
    }

    public Integer getForeignersNumber() {
        return foreignersNumber;
    }

    public void setForeignersNumber(Integer foreignersNumber) {
        this.foreignersNumber = foreignersNumber;
    }

    public Double getForeignersPercentage() {
        return foreignersPercentage;
    }

    public void setForeignersPercentage(Double foreignersPercentage) {
        this.foreignersPercentage = foreignersPercentage;
    }

    public Integer getNationalTeamPlayers() {
        return nationalTeamPlayers;
    }

    public void setNationalTeamPlayers(Integer nationalTeamPlayers) {
        this.nationalTeamPlayers = nationalTeamPlayers;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Integer getStadiumSeats() {
        return stadiumSeats;
    }

    public void setStadiumSeats(Integer stadiumSeats) {
        this.stadiumSeats = stadiumSeats;
    }

    public Double getNetTransferRecord() {
        return netTransferRecord;
    }

    public void setNetTransferRecord(Double netTransferRecord) {
        this.netTransferRecord = netTransferRecord;
    }

    public Integer getLastSeason() {
        return lastSeason;
    }

    public void setLastSeason(Integer lastSeason) {
        this.lastSeason = lastSeason;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
