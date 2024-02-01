package com.fdp.FDP_SpringBoot.club;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fdp.FDP_SpringBoot.competition.Competition;
import jakarta.persistence.*;
import java.util.Set;

/**
 * Represents a football club entity in the system.
 * This class is mapped to the 'clubs' table in the database.
 */
@Entity
@Table(name = "clubs")
public class Club {

    // Unique identifier for the club.
    @Id
    @Column(name = "club_id", nullable = false)
    private Integer clubId;

    // Short code representing the club, e.g., "FCB" for FC Barcelona.
    @Column(name = "club_code", length = 255)
    private String clubCode;

    // The name of the club.
    @Column(name = "name", length = 255)
    private String name;

    // The domestic competition in which the club participates.
    // Uses JsonBackReference to avoid circular serialization issues with JSON.
    @ManyToOne
    @JoinColumn(name = "domestic_competition_id")
    @JsonBackReference
    private Competition domesticCompetition;

    // The number of players in the club's squad.
    @Column(name = "squad_size")
    private Integer squadSize;

    // The average age of the players in the squad.
    @Column(name = "average_age")
    private Double averageAge;

    // The number of foreign players in the club.
    @Column(name = "foreigners_number")
    private Integer foreignersNumber;

    // The percentage of foreign players in the club.
    @Column(name = "foreigners_percentage")
    private Double foreignersPercentage;

    // The number of players in the club who are also national team players.
    @Column(name = "national_team_players")
    private Integer nationalTeamPlayers;

    // The name of the club's home stadium.
    @Column(name = "stadium_name", length = 255)
    private String stadiumName;

    // The seating capacity of the club's stadium.
    @Column(name = "stadium_seats")
    private Integer stadiumSeats;

    // The club's net transfer record. Positive values indicate net spending, while negative values indicate net earnings.
    @Column(name = "net_transfer_record")
    private Double netTransferRecord;

    // The last season in which the club participated.
    @Column(name = "last_season")
    private Integer lastSeason;

    // The URL to the club's official website or a relevant resource.
    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    // Default constructor for JPA.
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
