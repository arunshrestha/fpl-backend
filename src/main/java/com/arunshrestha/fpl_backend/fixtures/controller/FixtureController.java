package com.arunshrestha.fpl_backend.fixtures.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arunshrestha.fpl_backend.fixtures.dto.FixtureDto;
import com.arunshrestha.fpl_backend.fixtures.service.FixtureService;

@RestController
@RequestMapping("/api/v1/fixtures")
public class FixtureController {

    private final FixtureService fixtureService;

    public FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService;
    }

    @GetMapping
    public ResponseEntity<List<FixtureDto>> getFixtures(
            @RequestParam(required = false) Integer gameweek,
            @RequestParam(required = false) Integer team) {
        List<FixtureDto> fixtures = fixtureService.getFixtures(gameweek, team)
                .stream()
                .map(FixtureDto::new)
                .toList();

        return ResponseEntity.ok(fixtures);
    }
}