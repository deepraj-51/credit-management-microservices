package com.deepraj.credit_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreditResponse {

    private Long id;
    private Long customerId;
    private Double totalAmount;
    private Double paidAmount;
    private Double remainingAmount;
}
