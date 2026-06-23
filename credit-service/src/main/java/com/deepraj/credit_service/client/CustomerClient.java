package com.deepraj.credit_service.client;

import com.deepraj.credit_service.dto.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "CUSTOMER-SERVICE"
        )
public interface CustomerClient {

    @GetMapping("/customers/{id}")
    CustomerResponse getCustomerById(
            @PathVariable Long id);
}