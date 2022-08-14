package com.microservices.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckerHistoryRepository fraudCheckerHistoryRepository;


    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckerHistoryRepository.save(FraudCheckHistory.builder().customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now()).build()
        );
        return false;
    }
}