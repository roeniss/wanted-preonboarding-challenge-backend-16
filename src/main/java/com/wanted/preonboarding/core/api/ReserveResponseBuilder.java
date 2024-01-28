package com.wanted.preonboarding.core.api;

public class ReserveResponseBuilder {
    private ReserveResponse.Performance performance;
    private ReserveResponse.Reserver reserver;

    public ReserveResponseBuilder setPerformance(
            Long round,
            String performanceName,
            String seat,
            Long performanceId) {
        this.performance = new ReserveResponse.Performance(round, performanceName, seat, performanceId);
        return this;
    }

    public ReserveResponseBuilder setReserver(
            String name,
            String phone) {
        this.reserver = new ReserveResponse.Reserver(name, phone);
        return this;
    }

    public ReserveResponse build() {
        return new ReserveResponse(performance, reserver);
    }
}