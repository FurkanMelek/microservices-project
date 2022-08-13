package com.microservices.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(sequenceName = "fraud_id_seq", name = "fraud_id_seq")
    @GeneratedValue(generator = "fraud_id_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer customerId;
    private boolean isFraudster;
    private LocalDateTime createdAt;

}
