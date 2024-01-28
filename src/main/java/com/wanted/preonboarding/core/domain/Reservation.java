package com.wanted.preonboarding.core.domain;

public record Reservation(
        String reserverName,
        String reserverPhone,

        String performanceId,
        String performanceName,
        int performanceRound,
        String performanceSeat
) {

}
