package com.wanted.preonboarding.core.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PerformanceRepositoryTest {

    @Autowired
    private PerformanceRepository sut;
    @Autowired
    private TestEntityManager tem;

    @Test
    void save_performance_entity_correctly() {
        var entity = new Performance();
        UUID uuid = UUID.randomUUID();
        entity.setName("공연");
        entity.setPrice(10000);
        entity.setRound(1);
        entity.setType(PerformanceType.CONCERT);
        entity.setStartDate(Instant.now());
        entity.setReserve(false);
        sut.save(entity);

        tem.flush();

        List<Performance> result = sut.findAll();

        int size = result.size();
        Assertions.assertThat(size).isEqualTo(1);
        Assertions.assertThat(result.getFirst().getId()).isNotNull();
        Assertions.assertThat(result.getFirst().getName()).isEqualTo("공연");
        Assertions.assertThat(result.getFirst().getPrice()).isEqualTo(10000);
        Assertions.assertThat(result.getFirst().getRound()).isEqualTo(1);
        Assertions.assertThat(result.getFirst().getType()).isEqualTo(PerformanceType.CONCERT);
        Assertions.assertThat(result.getFirst().getStartDate()).isNotNull();
        Assertions.assertThat(result.getFirst().isReserve()).isEqualTo(false);
    }

    @Test
    void print_performance_without_circulr_reference() {
        var entity = new Performance();
        UUID uuid = UUID.randomUUID();
        entity.setName("공연");
        entity.setPrice(10000);
        entity.setRound(1);
        entity.setType(PerformanceType.CONCERT);
        entity.setStartDate(Instant.now());
        entity.setReserve(false);
        sut.save(entity);

        tem.flush();

        List<Performance> result = sut.findAll();

        System.out.println(Arrays.toString(result.toArray()));

    }
}