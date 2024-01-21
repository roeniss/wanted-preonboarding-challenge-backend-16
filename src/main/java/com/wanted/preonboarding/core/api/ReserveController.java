package com.wanted.preonboarding.core.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReserveController {
    @PostMapping("/api/v1/performances/reserve")
    public ResponseWrapper<ReserveResponse> reserve(@Valid @RequestBody ReserveRequest req) {
        return ResponseWrapper.created(new ReserveResponse(
                new ReserveResponse.Performance(req.round(), req.performanceId().toString(), req.seat(), req.performanceId()),
                new ReserveResponse.Reserver(req.name(), req.phone())
        ));
    }
}
