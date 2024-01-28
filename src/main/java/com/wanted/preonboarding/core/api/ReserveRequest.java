package com.wanted.preonboarding.core.api;

public record ReserveRequest(
        String reserverName,
        String reserverPhone,
        Long reserverBalance,
        Long performanceId,
        Long performanceRound,
        String performanceSeat
) {
}
