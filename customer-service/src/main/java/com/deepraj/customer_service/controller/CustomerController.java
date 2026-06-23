package com.deepraj.customer_service.controller;

import com.deepraj.customer_service.dto.CreateCustomerRequest;
import com.deepraj.customer_service.dto.CustomerResponse;
import com.deepraj.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponse createCustomer(
            @RequestBody
            @Valid
            CreateCustomerRequest request) {

        return customerService
                .createCustomer(request);
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(
            @PathVariable long id){
        return customerService.getCustomerById(id);
    }
    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(
            @PathVariable Long id,
            @Valid
            @RequestBody
            CreateCustomerRequest request){
        return customerService.updateCustomer(id, request);
    }
    @DeleteMapping("/{id}")
    public CustomerResponse deleteCustomer(
            @PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
