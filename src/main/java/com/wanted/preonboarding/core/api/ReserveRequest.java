package com.wanted.preonboarding.core.api;

public record ReserveRequest(
        String name,
        String phone,
        Long balance,
        Long performanceId,
        Long round,
        String seat
) {
}
