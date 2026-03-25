package com.arunshrestha.fpl_backend.fixtures.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arunshrestha.fpl_backend.fixtures.dto.FixtureDto;
import com.arunshrestha.fpl_backend.fixtures.service.FixtureService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/fixtures")
@Tag(name = "Fixtures", description = "FPL fixture data")
public class FixtureController {

    private final FixtureService fixtureService;

    public FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService;
    }

    @GetMapping
    @Operation(summary = "Get fixtures", description = "Returns all fixtures. Optionally filter by gameweek, team, and/or finished status.")
    public ResponseEntity<List<FixtureDto>> getFixtures(
            @Parameter(description = "Gameweek number (1-38)") @RequestParam(required = false) Integer gameweek,
            @Parameter(description = "Team ID") @RequestParam(required = false) Integer team,
            @Parameter(description = "Filter by finished status (true=played, false=upcoming)") @RequestParam(required = false) Boolean finished) {
        List<FixtureDto> fixtures = fixtureService.getFixtures(gameweek, team, finished)
                .stream()
                .map(FixtureDto::new)
                .toList();

        return ResponseEntity.ok(fixtures);
    }
}