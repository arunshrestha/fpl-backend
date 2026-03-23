package com.arunshrestha.fpl_backend.fixtures.dto;

import com.arunshrestha.fpl_backend.fixtures.model.Fixture;

import lombok.Getter;

@Getter
public class FixtureDto {

    private final Long fixtureId;
    private final Integer gameweekId;
    private final String gameweekName;
    private final Integer homeTeamId;
    private final String homeTeamName;
    private final Integer awayTeamId;
    private final String awayTeamName;
    private final Integer homeTeamScore;
    private final Integer awayTeamScore;
    private final Integer homeTeamDifficulty;
    private final Integer awayTeamDifficulty;
    private final Boolean finished;

    public FixtureDto(Fixture fixture) {
        this.fixtureId = fixture.getFixtureId();
        this.gameweekId = fixture.getGameweekId();
        this.gameweekName = fixture.getGameweekName();
        this.homeTeamId = fixture.getHomeTeamId();
        this.homeTeamName = fixture.getHomeTeamName();
        this.awayTeamId = fixture.getAwayTeamId();
        this.awayTeamName = fixture.getAwayTeamName();
        this.homeTeamScore = toIntOrNull(fixture.getHomeTeamScore());
        this.awayTeamScore = toIntOrNull(fixture.getAwayTeamScore());
        this.homeTeamDifficulty = fixture.getHomeTeamDifficulty();
        this.awayTeamDifficulty = fixture.getAwayTeamDifficulty();
        this.finished = fixture.getFinished();
    }

    private Integer toIntOrNull(Double value) {
        return (value == null || value.isNaN()) ? null : value.intValue();
    }
}