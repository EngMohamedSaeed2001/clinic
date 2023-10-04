package com.example.doctor.Model.DTO;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PaymentDTO {

    private Long id;

    private String transactionId;
    private Double amount;
    private Long patientId;
}