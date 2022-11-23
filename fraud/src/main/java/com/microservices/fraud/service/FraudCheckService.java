package com.microservices.fraud.service;

import com.microservices.fraud.dto.FraudCheckRequest;
import com.microservices.fraud.repository.FraudCheckerHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckerHistoryRepository fraudCheckerHistoryRepository;


    public boolean isFraudulentCustomer(FraudCheckRequest fraudCheckRequest) {

        if (fraudCheckRequest.name().equalsIgnoreCase("Ali")
                || fraudCheckRequest.surname().equalsIgnoreCase("Veli")) {
            return true;
        }
        return false;
    }
}
