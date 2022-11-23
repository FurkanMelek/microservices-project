package com.microservices.fraud.controller;

import com.microservices.fraud.dto.FraudCheckRequest;
import com.microservices.fraud.dto.FraudCheckResponse;
import com.microservices.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @PostMapping
    public ResponseEntity<FraudCheckResponse> isFraudulentCustomer(@RequestBody FraudCheckRequest fraudCheckRequest) {
        return ResponseEntity.ok(new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(fraudCheckRequest)));
    }

}
