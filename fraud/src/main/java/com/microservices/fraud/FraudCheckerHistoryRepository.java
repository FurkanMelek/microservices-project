package com.microservices.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckerHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

}
