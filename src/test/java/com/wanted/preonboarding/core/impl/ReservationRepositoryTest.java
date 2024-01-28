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
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository sut;
    @Autowired
    private TestEntityManager tem;

    @Test
    void save_reservation_entity() {
        var performance = createSamplePerformance();
        var seat = createSamplePerformanceSeatInfo('A');
        var reservation = createSampleReservation();
        performance.addSeat(seat);
        seat.reserve(reservation);

        Performance savedPerformance = tem.persistFlushFind(performance);

        var result = savedPerformance.getSeats().stream().findFirst().get().getReservation();

        Assertions.assertThat(result.getName()).isEqualTo("홍길동");
        Assertions.assertThat(result.getPhoneNumber()).isEqualTo("010-1234-5678");
    }

    @Test
    void eager_fetch_on_performance_seat_info() { // TODO: query count 검증을 (눈으로 체크하는 대신) 자동화
        var performance = createSamplePerformance();
        var seat = createSamplePerformanceSeatInfo('A');
        var reservation = createSampleReservation();
        performance.addSeat(seat);
        seat.reserve(reservation);

        tem.persistAndFlush(performance);
        tem.detach(performance);
        tem.detach(seat);
        tem.detach(reservation);

        var result = tem.find(Reservation.class, reservation.getId());

        System.out.println(result.getPerformanceSeatInfo());
    }

}