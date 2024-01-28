package com.wanted.preonboarding.core.api.controller;

import com.wanted.preonboarding.core.api.ReserveRequest;
import com.wanted.preonboarding.core.api.ReserveResponse;
import com.wanted.preonboarding.core.api.ReserveResponseBuilder;
import com.wanted.preonboarding.core.api.ResponseWrapper;
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
                10000,
                1,
                1,
                "A1"
        ));

        // then
        assertEquals(HttpStatus.CREATED, response.statusCode());
    }

    @Test
    void 공연_예약_성공_시_공연_정보와_예매자_정보를_받는다() {
        // given
        ReserveController sut = new ReserveController();

        // when
        ResponseWrapper<ReserveResponse> response = sut.reserve(new ReserveRequest(
                "홍길동",
                "010-1234-5678",
                10000,
                1,
                1,
                "A1"
        ));

        // then
        ReserveResponse expected = new ReserveResponseBuilder().setReserver("홍길동", "010-1234-5678").build();
        assertEquals(expected.reserver(), response.data().reserver());
    }

    @Test
    void 공연_예약_성공_시_공연_정보와_공연_정보를_받는다() {
        // given
        ReserveController sut = new ReserveController();

        // when
        ResponseWrapper<ReserveResponse> response = sut.reserve(new ReserveRequest(
                "홍길동",
                "010-1234-5678",
                10000,
                1,
                1,
                "A1"
        ));

        // then
        ReserveResponse expected = new ReserveResponseBuilder().setPerformance(1, "1", "A1", 1).build();
        assertEquals(expected.performance(), response.data().performance());
    }
}