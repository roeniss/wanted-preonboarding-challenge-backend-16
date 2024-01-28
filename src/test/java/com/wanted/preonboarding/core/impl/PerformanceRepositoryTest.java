package com.wanted.preonboarding.core.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static com.wanted.preonboarding.core.impl.DummyEntityFactory.createSamplePerformance;
import static com.wanted.preonboarding.core.impl.DummyEntityFactory.createSamplePerformanceSeatInfo;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PerformanceRepositoryTest {

    @Autowired
    private PerformanceRepository sut;
    @Autowired
    private TestEntityManager tem;

    @Test
    void save_performance_entity() {
        var performance = createSamplePerformance();

        Performance result = tem.persistFlushFind(performance);

        Assertions.assertThat(result.getId()).isNotNull();
        Assertions.assertThat(result.getName()).isEqualTo("공연");
        Assertions.assertThat(result.getPrice()).isEqualTo(10000);
        Assertions.assertThat(result.getRound()).isEqualTo(1);
        Assertions.assertThat(result.getType()).isEqualTo(PerformanceType.CONCERT);
        Assertions.assertThat(result.getStartDate()).isNotNull();
    }

    @Test
    void lazy_fetch_on_seats() { // TODO: query count 검증을 (눈으로 체크하는 대신) 자동화
        var performance = createSamplePerformance();
        performance.addSeat(createSamplePerformanceSeatInfo('A'));
        performance.addSeat(createSamplePerformanceSeatInfo('B'));
        performance.addSeat(createSamplePerformanceSeatInfo('C'));

        Performance result = tem.persistFlushFind(performance);

        System.out.println(result.getSeats());
    }
}