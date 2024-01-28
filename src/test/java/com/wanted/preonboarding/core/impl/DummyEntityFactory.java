package com.wanted.preonboarding.core.impl;

import java.time.Instant;

public class DummyEntityFactory {
    public static Performance createSamplePerformance() {
        var performance = new Performance();
        performance.setName("공연");
        performance.setPrice(10000);
        performance.setRound(1);
        performance.setType(PerformanceType.CONCERT);
        performance.setStartDate(Instant.now());
        return performance;
    }

    public static PerformanceSeatInfo createSamplePerformanceSeatInfo(char line) {
        var seat = new PerformanceSeatInfo();
        seat.setGate(1);
        seat.setLine(line);
        seat.setSeat(2);
        seat.setReserve(false);
        return seat;
    }

    public static Reservation createSampleReservation() {
        var reservation = new Reservation();
        reservation.setName("홍길동");
        reservation.setPhoneNumber("010-1234-5678");
        return reservation;
    }
}
