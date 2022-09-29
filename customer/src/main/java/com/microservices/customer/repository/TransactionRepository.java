package com.microservices.customer.repository;

import com.microservices.customer.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}

