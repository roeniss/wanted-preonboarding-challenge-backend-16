package com.wanted.preonboarding.core.domain;

import java.util.UUID;

public record Reservation(
        String reserverName,
        String reserverPhone,

        UUID performanceId,
        String performanceName,
        int performanceRound,
        String performanceSeat
) {

}
