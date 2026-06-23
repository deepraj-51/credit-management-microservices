package com.deepraj.credit_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCreditRequest {
    @NotNull
    private Long customerId;

    @NotNull
    private Double totalAmount;
}
