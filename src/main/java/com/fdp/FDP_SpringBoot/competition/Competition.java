package com.fdp.FDP_SpringBoot.competition;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fdp.FDP_SpringBoot.club.Club;
import jakarta.persistence.*;

import java.util.Set;

/**
 * Represents a competition entity, like a football league or tournament.
 * This class is mapped to the 'competitions' table in the database.
 */
@Entity
@Table(name = "competitions")
public class Competition {

    // Unique identifier for the competition.
    @Id
    @Column(name = "competition_id", nullable = false)
    private String competitionId;

    // Short code representing the competition, e.g., "EPL" for English Premier League.
    @Column(name = "competition_code")
    private String competitionCode;

    // Clubs participating in this competition.
    // Uses JsonManagedReference for proper JSON serialization handling.
    @OneToMany(mappedBy = "domesticCompetition")
    @JsonManagedReference
    private Set<Club> clubs;

    // The name of the competition.
    @Column(name = "name")
    private String name;

    // Subtype of the competition, if applicable.
    @Column(name = "sub_type")
    private String subType;

    // The type or category of the competition, e.g., 'League', 'Cup'.
    @Column(name = "type")
    private String type;

    // Identifier for the country associated with the competition.
    @Column(name = "country_id")
    private Integer countryId;

    // Name of the country associated with the competition.
    @Column(name = "country_name")
    private String countryName;

    // Code for the domestic league, if this competition is part of a larger league structure.
    @Column(name = "domestic_league_code")
    private String domesticLeagueCode;

    // Confederation under which the competition is organized, e.g., UEFA, CONMEBOL.
    @Column(name = "confederation")
    private String confederation;

    // URL to a webpage with more information about the competition.
    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    // Default constructor for JPA.
    public Competition() {
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionCode() {
        return competitionCode;
    }

    public void setCompetitionCode(String competitionCode) {
        this.competitionCode = competitionCode;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDomesticLeagueCode() {
        return domesticLeagueCode;
    }

    public void setDomesticLeagueCode(String domesticLeagueCode) {
        this.domesticLeagueCode = domesticLeagueCode;
    }

    public String getConfederation() {
        return confederation;
    }

    public void setConfederation(String confederation) {
        this.confederation = confederation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}