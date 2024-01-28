package com.wanted.preonboarding.core.api.controller;

import com.wanted.preonboarding.core.api.ReserveRequest;
import com.wanted.preonboarding.core.api.ReserveResponse;
import com.wanted.preonboarding.core.api.ReserveResponseBuilder;
import com.wanted.preonboarding.core.api.ResponseWrapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReserveController {
    @PostMapping("/api/v1/performances/reserve")
    public ResponseWrapper<ReserveResponse> reserve(@Valid @RequestBody ReserveRequest req) {
        return ResponseWrapper.created(new ReserveResponseBuilder()
                .setPerformance(req.round(), req.performanceId().toString(), req.seat(), req.performanceId()) // TODO: find performanceName
                .setReserver(req.name(), req.phone())
                .build());
    }
}
