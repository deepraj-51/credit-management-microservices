package com.deepraj.credit_service.controller;

import com.deepraj.credit_service.dto.CreateCreditRequest;
import com.deepraj.credit_service.dto.CreditResponse;
import com.deepraj.credit_service.entity.Credit;
import com.deepraj.credit_service.service.CreditService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    @PostMapping
    public CreditResponse createCredit(
            @Valid
            @RequestBody
            CreateCreditRequest request){
        return creditService.createCredit(request);
    }

    @GetMapping("/customer/{customerId}")
    public List<CreditResponse>
    getCreditsByCustomerId(
            @PathVariable Long customerId) {

        return creditService.getCreditByCustomerId(customerId);
    }

}
