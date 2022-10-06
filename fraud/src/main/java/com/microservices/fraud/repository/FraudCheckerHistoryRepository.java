package com.microservices.fraud.repository;

import com.microservices.fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckerHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

}
