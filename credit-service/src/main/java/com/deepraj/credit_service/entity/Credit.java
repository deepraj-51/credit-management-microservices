package com.deepraj.credit_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Double totalAmount;

    private Double paidAmount;

    private Double remainingAmount;
}
