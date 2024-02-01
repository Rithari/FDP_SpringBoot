package com.fdp.FDP_SpringBoot.player;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fdp.FDP_SpringBoot.club.Club;
import jakarta.persistence.*;
import java.util.Date;

/**
 * Entity class representing a player.
 * Mapped to the 'players' table in the database.
 */
@Entity
@Table(name = "players")
public class Player {

    // Unique identifier for the player.
    @Id
    @Column(name = "player_id")
    private Integer playerId;

    // First name of the player.
    @Column(name = "first_name")
    private String firstName;

    // Last name of the player.
    @Column(name = "last_name")
    private String lastName;

    // Full name of the player.
    @Column(name = "name")
    private String name;

    // The last season in which the player was active.
    @Column(name = "last_season")
    private Integer lastSeason;

    // ID of the club the player currently plays for.
    @Column(name = "current_club_id")
    private Integer currentClubId;

    // Reference to the current club entity. Prevents circular serialization issues.
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "current_club_id", referencedColumnName = "club_id", insertable = false, updatable = false)
    private Club currentClub;

    // A unique code identifying the player.
    @Column(name = "player_code")
    private String playerCode;

    // Country where the player was born.
    @Column(name = "country_of_birth")
    private String countryOfBirth;

    // City where the player was born.
    @Column(name = "city_of_birth")
    private String cityOfBirth;

    // Country of the player's citizenship.
    @Column(name = "country_of_citizenship")
    private String countryOfCitizenship;

    // The player's date of birth.
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    // Sub-position of the player on the field.
    @Column(name = "sub_position")
    private String subPosition;

    // Main position of the player on the field.
    @Column(name = "position")
    private String position;

    // Preferred foot of the player (left/right).
    @Column(name = "foot")
    private String foot;

    // Height of the player in centimeters.
    @Column(name = "height_in_cm")
    private Double heightInCm;

    // Current market value of the player in euros.
    @Column(name = "market_value_in_eur")
    private Double marketValueInEur;

    // Highest market value of the player in euros.
    @Column(name = "highest_market_value_in_eur")
    private Double highestMarketValueInEur;

    // Date when the player's current contract expires.
    @Column(name = "contract_expiration_date")
    @Temporal(TemporalType.DATE)
    private Date contractExpirationDate;

    // Name of the player's agent.
    @Column(name = "agent_name")
    private String agentName;

    // URL to the player's image.
    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    // URL to a webpage with more information about the player.
    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    // ID of the domestic competition of the player's current club.
    @Column(name = "current_club_domestic_competition_id")
    private String currentClubDomesticCompetitionId;

    // Name of the player's current club.
    @Column(name = "current_club_name")
    private String currentClubName;

    // The player's age, calculated from the date of birth.
    @Column(name = "age")
    private Double age;

    // Default constructor for JPA.
    public Player() {
    }

    public Club getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(Club currentClub) {
        this.currentClub = currentClub;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLastSeason() {
        return lastSeason;
    }

    public void setLastSeason(Integer lastSeason) {
        this.lastSeason = lastSeason;
    }

    public Integer getCurrentClubId() {
        return currentClubId;
    }

    public void setCurrentClubId(Integer currentClubId) {
        this.currentClubId = currentClubId;
    }

    public String getPlayerCode() {
        return playerCode;
    }

    public void setPlayerCode(String playerCode) {
        this.playerCode = playerCode;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public String getCountryOfCitizenship() {
        return countryOfCitizenship;
    }

    public void setCountryOfCitizenship(String countryOfCitizenship) {
        this.countryOfCitizenship = countryOfCitizenship;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSubPosition() {
        return subPosition;
    }

    public void setSubPosition(String subPosition) {
        this.subPosition = subPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public Double getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(Double heightInCm) {
        this.heightInCm = heightInCm;
    }

    public Double getMarketValueInEur() {
        return marketValueInEur;
    }

    public void setMarketValueInEur(Double marketValueInEur) {
        this.marketValueInEur = marketValueInEur;
    }

    public Double getHighestMarketValueInEur() {
        return highestMarketValueInEur;
    }

    public void setHighestMarketValueInEur(Double highestMarketValueInEur) {
        this.highestMarketValueInEur = highestMarketValueInEur;
    }

    public Date getContractExpirationDate() {
        return contractExpirationDate;
    }

    public void setContractExpirationDate(Date contractExpirationDate) {
        this.contractExpirationDate = contractExpirationDate;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCurrentClubDomesticCompetitionId() {
        return currentClubDomesticCompetitionId;
    }

    public void setCurrentClubDomesticCompetitionId(String currentClubDomesticCompetitionId) {
        this.currentClubDomesticCompetitionId = currentClubDomesticCompetitionId;
    }

    public String getCurrentClubName() {
        return currentClubName;
    }

    public void setCurrentClubName(String currentClubName) {
        this.currentClubName = currentClubName;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }
}

