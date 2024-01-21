package com.wanted.preonboarding.core.api;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReserveControllerTest {

    @Test
    void 공연_예약_성공_시_201_statusCode를_받는다() {
        // given
        ReserveController sut = new ReserveController();

        // when
        ResponseWrapper<ReserveResponse> response = sut.reserve(new ReserveRequest(
                "홍길동",
                "010-1234-5678",
                10000L,
                1L,
                1L,
                "A1"
        ));

        // then
        assertEquals(response.statusCode(), HttpStatus.CREATED);
    }

    @Test
    void 공연_예약_성공_시_공연_정보와_예매자_정보를_받는다() {
        // given
        ReserveController sut = new ReserveController();

        // when
        ResponseWrapper<ReserveResponse> response = sut.reserve(new ReserveRequest(
                "홍길동",
                "010-1234-5678",
                10000L,
                1L,
                1L,
                "A1"
        ));

        // then
        assertEquals(response.data().reserver().name(), "홍길동");
        assertEquals(response.data().reserver().phone(), "010-1234-5678");
    }

    @Test
    void 공연_예약_성공_시_공연_정보와_공연_정보를_받는다() {
        // given
        ReserveController sut = new ReserveController();

        // when
        ResponseWrapper<ReserveResponse> response = sut.reserve(new ReserveRequest(
                "홍길동",
                "010-1234-5678",
                10000L,
                1L,
                1L,
                "A1"
        ));

        // then
        assertEquals(response.data().performance().round(), 1L);
        assertEquals(response.data().performance().performanceName(), "1");
        assertEquals(response.data().performance().seat(), "A1");
        assertEquals(response.data().performance().performanceId(), 1L);
    }
}