package com.arunshrestha.fpl_backend.fixtures.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arunshrestha.fpl_backend.fixtures.model.Fixture;
import com.arunshrestha.fpl_backend.fixtures.repository.FixtureRepository;

import jakarta.persistence.criteria.Predicate;

@Service
public class FixtureService {

    private final FixtureRepository fixtureRepository;

    public FixtureService(FixtureRepository fixtureRepository) {
        this.fixtureRepository = fixtureRepository;
    }

    public List<Fixture> getFixtures(Integer gameweek, Integer teamId, Boolean finished) {
        return fixtureRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (gameweek != null) {
                predicates.add(cb.equal(root.get("gameweekId"), gameweek));
            }

            if (teamId != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("homeTeamId"), teamId),
                        cb.equal(root.get("awayTeamId"), teamId)));
            }

            if (finished != null) {
                predicates.add(cb.equal(root.get("finished"), finished));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }

}
