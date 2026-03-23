package com.arunshrestha.fpl_backend.fixtures.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dim_fixtures", schema = "mart")
public class Fixture {

    @Id
    @Column(name = "fixture_id")
    private Long fixtureId;

    @Column(name = "gameweek_id")
    private Integer gameweekId;

    @Column(name = "gameweek_name")
    private String gameweekName;

    @Column(name = "home_team_id")
    private Integer homeTeamId;

    @Column(name = "home_team_name")
    private String homeTeamName;

    @Column(name = "away_team_id")
    private Integer awayTeamId;

    @Column(name = "away_team_name")
    private String awayTeamName;

    @Column(name = "home_team_score")
    private Double homeTeamScore;

    @Column(name = "away_team_score")
    private Double awayTeamScore;

    @Column(name = "home_team_difficulty")
    private Integer homeTeamDifficulty;

    @Column(name = "away_team_difficulty")
    private Integer awayTeamDifficulty;

    @Column(name = "finished")
    private Boolean finished;
}