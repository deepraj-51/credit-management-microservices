package com.deepraj.credit_service.repository;

import com.deepraj.credit_service.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository
            extends JpaRepository<Credit, Long> {
    List<Credit> findByCustomerId(Long customerId);
}
