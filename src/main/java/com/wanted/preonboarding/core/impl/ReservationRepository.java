package com.wanted.preonboarding.core.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByNameAndPhoneNumber(String name, String phoneNumber);
}
