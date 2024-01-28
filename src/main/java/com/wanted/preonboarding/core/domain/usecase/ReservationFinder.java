package com.wanted.preonboarding.core.domain.usecase;

import com.wanted.preonboarding.core.domain.Reservation;
import com.wanted.preonboarding.core.impl.ReservationRepository;

public class ReservationFinder {
    private final ReservationRepository reservationRepository;

    public ReservationFinder(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation find(String reserverName, String reserverPhone) {
        var entity = reservationRepository.findByNameAndPhoneNumber(reserverName, reserverPhone);
        if (entity == null) {
            return null;
        }
        return convert(entity);
    }

    public Reservation convert(com.wanted.preonboarding.core.impl.Reservation entity) {
        return new Reservation(
                entity.getName(),
                entity.getPhoneNumber(),
                entity.getPerformanceSeatInfo().getPerformance().getId(),
                entity.getPerformanceSeatInfo().getPerformance().getName(),
                entity.getPerformanceSeatInfo().getPerformance().getRound(),
                entity.getPerformanceSeatInfo().getSeat() + ":" + entity.getPerformanceSeatInfo().getLine());
    }
}
