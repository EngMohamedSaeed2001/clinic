package com.example.payment.Model.DTO;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AddPaymentDTO {
    private Double amount;
    private Long patientId;
}