package com.deepraj.credit_service.service;

import com.deepraj.credit_service.client.CustomerClient;
import com.deepraj.credit_service.dto.CreateCreditRequest;
import com.deepraj.credit_service.dto.CreditResponse;
import com.deepraj.credit_service.dto.CustomerResponse;
import com.deepraj.credit_service.entity.Credit;
import com.deepraj.credit_service.exception.CustomerNotFoundException;
import com.deepraj.credit_service.repository.CreditRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditRepository repository;
    private final CustomerClient customerClient;


    @CircuitBreaker(
            name = "customerService",
            fallbackMethod = "customerServiceFallback"
    )
    public CreditResponse createCredit(
            CreateCreditRequest request){

        customerClient.getCustomerById(
                request.getCustomerId());

        Credit credit = Credit.builder()
                .customerId(
                        request.getCustomerId())
                .totalAmount(
                        request.getTotalAmount())
                .paidAmount(0.0)
                .remainingAmount(
                        request.getTotalAmount())
                .build();
        Credit saved = repository.save(credit);

        return mapToResponse(saved);
    }

    public CreditResponse customerServiceFallback(
            CreateCreditRequest request,
            Exception ex) {

        return CreditResponse.builder()
                .id(null)
                .customerId(request.getCustomerId())
                .totalAmount(0.0)
                .paidAmount(0.0)
                .remainingAmount(0.0)
                .build();

    }

    public List<CreditResponse> getCreditByCustomerId(
            Long customerId){
        return repository.findByCustomerId(customerId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    private CreditResponse mapToResponse(
            Credit credit){

        return CreditResponse.builder()
                .id(credit.getId())
                .customerId(credit.getCustomerId())
                .totalAmount(credit.getTotalAmount())
                .paidAmount(credit.getPaidAmount())
                .remainingAmount(credit.getRemainingAmount())
                .build();
    }
}
