package com.microservices.fraud.service;

import com.microservices.fraud.entity.FraudCheckHistory;
import com.microservices.fraud.repository.FraudCheckerHistoryRepository;
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
