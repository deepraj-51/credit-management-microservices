package com.deepraj.customer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerResponse {

    private Long id;

    private String name;

    private String mobile;

    private String address;
}
