package com.wanted.preonboarding.core.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static com.wanted.preonboarding.core.impl.DummyEntityFactory.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PerformanceSeatInfoRepositoryTest {

    @Autowired
    private PerformanceSeatInfoRepository sut;
    @Autowired
    private TestEntityManager tem;

    @Test
    void save_performance_seat_info_entity() {
        var seat = createSamplePerformanceSeatInfo('A');
        var performance = createSamplePerformance();
        performance.addSeat(seat);

        PerformanceSeatInfo result = tem.persistFlushFind(performance).getSeats().iterator().next();

        Assertions.assertThat(result.getGate()).isEqualTo(1);
        Assertions.assertThat(result.getLine()).isEqualTo('A');
        Assertions.assertThat(result.getSeat()).isEqualTo(2);
        Assertions.assertThat(result.isReserve()).isEqualTo(false);
    }

    @Test
    void eager_fetch_on_seats() { // TODO: query count 검증을 (눈으로 체크하는 대신) 자동화
        var seat = createSamplePerformanceSeatInfo('A');
        var performance = createSamplePerformance();
        performance.addSeat(seat);
        tem.persistAndFlush(performance);
        tem.detach(performance);
        tem.detach(seat);

        PerformanceSeatInfo result = tem.find(PerformanceSeatInfo.class, seat.getId());

        System.out.println(result.getPerformance());
    }

    @Test
    void eager_fetch_on_reservation() { // TODO: query count 검증을 (눈으로 체크하는 대신) 자동화
        var performance = createSamplePerformance();
        var seat = createSamplePerformanceSeatInfo('A');
        var reservation = createSampleReservation();
        performance.addSeat(seat);
        seat.reserve(reservation);

        tem.persistAndFlush(performance);
        tem.detach(performance);
        tem.detach(seat);
        tem.detach(reservation);

        var result = tem.find(PerformanceSeatInfo.class, seat.getId());

        System.out.println(result.getReservation());
    }
}