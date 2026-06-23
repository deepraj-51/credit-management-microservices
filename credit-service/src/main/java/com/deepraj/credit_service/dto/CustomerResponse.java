package com.deepraj.credit_service.dto;

import lombok.Data;

@Data
public class CustomerResponse {

    private Long id;

    private String name;

    private String mobile;

    private String address;
}
