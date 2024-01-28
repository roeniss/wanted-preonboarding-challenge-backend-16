package com.wanted.preonboarding.core.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository sut;
    @Autowired
    private TestEntityManager tem;

    @Test
    void save_reservation_entity_correctly() {
        var entity = new Reservation();
        UUID uuid = UUID.randomUUID();
        entity.setName("홍길동");
        entity.setPhoneNumber("010-1234-5678");
        entity.setPerformanceId(uuid);
        entity.setRound(1);
        entity.setGate(2);
        entity.setLine('A');
        entity.setSeat(3);
        sut.save(entity);

        tem.flush();

        List<Reservation> result = sut.findAll();

        int size = result.size();
        Assertions.assertThat(size).isEqualTo(1);
        Assertions.assertThat(result.getFirst().getName()).isEqualTo("홍길동");
        Assertions.assertThat(result.getFirst().getPhoneNumber()).isEqualTo("010-1234-5678");
        Assertions.assertThat(result.getFirst().getPerformanceId()).isEqualTo(uuid);
        Assertions.assertThat(result.getFirst().getRound()).isEqualTo(1);
        Assertions.assertThat(result.getFirst().getGate()).isEqualTo(2);
        Assertions.assertThat(result.getFirst().getLine()).isEqualTo('A');
        Assertions.assertThat(result.getFirst().getSeat()).isEqualTo(3);
    }

    @Test
    void print_reservation_without_circulr_reference() {
        var entity = new Reservation();
        UUID uuid = UUID.randomUUID();
        entity.setName("홍길동");
        entity.setPhoneNumber("010-1234-5678");
        entity.setPerformanceId(uuid);
        entity.setRound(1);
        entity.setGate(2);
        entity.setLine('A');
        entity.setSeat(3);
        sut.save(entity);

        List<Reservation> result = sut.findAll();

        System.out.println(Arrays.toString(result.toArray()));
    }
}