package com.wanted.preonboarding.core.api;

public record ReserveResponse(
        Performance performance,
        Reserver reserver
) {

    record Performance(
            int round,
            String performanceName,
            String seat,
            int performanceId
    ) {
    }

    record Reserver(
            String name,
            String phone
    ) {
    }
}

