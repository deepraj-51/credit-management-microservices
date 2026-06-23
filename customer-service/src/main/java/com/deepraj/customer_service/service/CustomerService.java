package com.deepraj.customer_service.service;

import com.deepraj.customer_service.dto.CreateCustomerRequest;
import com.deepraj.customer_service.dto.CustomerResponse;
import com.deepraj.customer_service.entity.Customer;
import com.deepraj.customer_service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerResponse createCustomer(
            CreateCustomerRequest request) {

        Customer customer =
                Customer.builder()
                        .name(request.getName())
                        .mobile(request.getMobile())
                        .address(request.getAddress())
                        .build();

        Customer saved =
                repository.save(customer);

        return CustomerResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .mobile(saved.getMobile())
                .address(saved.getAddress())
                .build();
    }
    public List<CustomerResponse> getAllCustomers(){
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    public CustomerResponse getCustomerById(Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(()-> new RuntimeException(
                        "Customer not found"));
        return mapToResponse(customer);
    }
    public CustomerResponse updateCustomer(
            Long id,
            CreateCustomerRequest request){

        Customer customer = repository.findById(id)
                .orElseThrow(()->
                        new RuntimeException(
                                "customer not found"));
        customer.setName(request.getName());
        customer.setMobile(request.getMobile());
        customer.setAddress(request.getAddress());

        Customer updated = repository.save(customer);
        return mapToResponse(updated);
    }

    public CustomerResponse deleteCustomer(Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(()->
                        new RuntimeException(
                                "customer not found"));
        repository.deleteById(id);
        return mapToResponse(customer);
    }

    private CustomerResponse mapToResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .mobile(customer.getMobile())
                .address(customer.getAddress())
                .build();
    }
}
