package com.wanted.preonboarding.core.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceSeatInfoRepository extends JpaRepository<PerformanceSeatInfo, Integer> {
}

