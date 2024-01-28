package com.wanted.preonboarding.core.api;

public record ReserveRequest(
        String reserverName,
        String reserverPhone,
        int reserverBalance,
        int performanceId,
        int performanceRound,
        String performanceSeat
) {
}
