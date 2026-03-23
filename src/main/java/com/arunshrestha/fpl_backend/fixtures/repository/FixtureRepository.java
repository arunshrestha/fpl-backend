package com.arunshrestha.fpl_backend.fixtures.repository;

import com.arunshrestha.fpl_backend.fixtures.model.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FixtureRepository extends JpaRepository<Fixture, Long>,
        JpaSpecificationExecutor<Fixture> {
}
