package com.wanted.preonboarding.core.api;

public record ReserveResponse(
        Performance performance,
        Reserver reserver
) {

    record Performance(
            Long round,
            String performanceName,
            String seat,
            Long performanceId
    ) {
    }

    record Reserver(
            String name,
            String phone
    ) {
    }
}

