package com.arunshrestha.fpl_backend.fixtures.dto;

import com.arunshrestha.fpl_backend.fixtures.model.Fixture;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Fixture data")
public class FixtureDto {

    @Schema(description = "Unique fixture ID")
    private final Long fixtureId;

    @Schema(description = "Gameweek number", example = "10")
    private final Integer gameweekId;

    @Schema(description = "Gameweek display name", example = "Gameweek 10")
    private final String gameweekName;

    @Schema(description = "Home team ID", example = "1")
    private final Integer homeTeamId;

    @Schema(description = "Home team name", example = "Arsenal")
    private final String homeTeamName;

    @Schema(description = "Away team ID", example = "12")
    private final Integer awayTeamId;

    @Schema(description = "Away team name", example = "Liverpool")
    private final String awayTeamName;

    @Schema(description = "Home team score, null if not played", example = "2")
    private final Integer homeTeamScore;

    @Schema(description = "Away team score, null if not played", example = "1")
    private final Integer awayTeamScore;

    @Schema(description = "Home team fixture difficulty rating (1-5)", example = "3")
    private final Integer homeTeamDifficulty;

    @Schema(description = "Away team fixture difficulty rating (1-5)", example = "4")
    private final Integer awayTeamDifficulty;

    @Schema(description = "Whether the fixture has been played", example = "true")
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